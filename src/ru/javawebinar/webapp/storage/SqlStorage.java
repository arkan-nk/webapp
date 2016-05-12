package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeNotFoundException;
import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.sql.SqlHelper;
import ru.javawebinar.webapp.util.HtmlUtil;

import java.sql.*;
import java.util.*;

/**
 * GKislin
 * http://javawebinar.ru/basejava/
 */
public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume");
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.execute(
                "SELECT * FROM resume r\n" +
                        "LEFT JOIN  contact c ON r.uuid = c.resume_uuid\n" +
                        "WHERE uuid=?",
                ps -> {

                    ps.setString(1, uuid);
                    ResultSet rs = ps.executeQuery();
                    if (!rs.next()) {
                        throw new ResumeStorageException(uuid, "Resume " + uuid + " is not exist");
                    }
                    Resume r = new Resume(uuid, rs.getString("full_name"), rs.getString("about"));
                    do {
                        addContact(rs, r);
                    } while (rs.next());
                    return r;
                });
    }

    @Override
    public void save(Resume r) {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (uuid, full_name, about) VALUES(?,?,?)")) {
                ps.setString(1, r.getUuid());
                ps.setString(2, r.getFullName());
                ps.setString(3, r.getAbout());
                ps.execute();
            }
            insertContact(conn, r);
            return null;
        });
    }

    @Override
    public void update(Resume r) {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement("UPDATE resume SET full_name = ?, about = ? WHERE uuid = ?")) {
                st.setString(1, r.getFullName());
                st.setString(2, r.getAbout());
                st.setString(3, r.getUuid());
                if (st.executeUpdate() == 0) {
                    throw new ResumeNotFoundException(r.getUuid());
                }
            }
            refreshContact(r);
            //deleteContacts(conn, r);
            //insertContact(conn, r);
            return null;
        });
    }

    private void refreshContact(Resume resume) throws SQLException {
        Resume clone = this.get(resume.getUuid());
        if (resume.getContacts().isEmpty() && clone.getContacts().isEmpty()) return;
        if (resume.getContacts().isEmpty() && !clone.getContacts().isEmpty()) {
            deleteMapContacts(clone.getUuid(), clone.getContacts());
            return;
        }
        refreshContact(resume, clone);
    }

    private void refreshContact(Resume resume, Resume clone) throws SQLException{
        if (resume.getContacts().isEmpty() && clone.getContacts().isEmpty()) return;
        if (resume.getContacts().isEmpty() && !clone.getContacts().isEmpty()) {
            deleteMapContacts(resume.getUuid(), clone.getContacts());
            return;
        }
        if (!resume.getContacts().isEmpty() && clone.getContacts().isEmpty()) {
            addMapContacts(resume.getUuid(), resume.getContacts());
            return;
        }
        Map<ContactType, String> contactsToAdd = new EnumMap<>(ContactType.class);
        Map<ContactType, String> contactsToRemove = new EnumMap<>(ContactType.class);
        Map<ContactType, String> contactsToUpdate = new EnumMap<>(ContactType.class);
        for (Map.Entry<ContactType,String> entryResume : resume.getContacts().entrySet()){
            ContactType keyResume = entryResume.getKey();
            if (clone.getContacts().containsKey(keyResume) &&
                    !clone.getContacts().get(keyResume).equals(entryResume.getValue())) {
                contactsToUpdate.put(keyResume, entryResume.getValue());
                continue;
            }
            if (!clone.getContacts().containsKey(keyResume)) {
                contactsToAdd.put(keyResume, entryResume.getValue());
            }
        }
        for (Map.Entry<ContactType,String> entryClone : clone.getContacts().entrySet()){
            ContactType keyClone = entryClone.getKey();
            if (!resume.getContacts().containsKey(keyClone)) {
                contactsToRemove.put(keyClone, entryClone.getValue());
            }
        }
        if (!contactsToAdd.isEmpty()) addMapContacts(resume.getUuid(), contactsToAdd);
        if (!contactsToRemove.isEmpty()) deleteMapContacts(resume.getUuid(),contactsToRemove);
        if (!contactsToUpdate.isEmpty()) updateMapContacts(resume.getUuid(),contactsToUpdate);
    }

    private void updateMapContacts(String uuid, Map<ContactType, String> contactsToUpdate) throws SQLException {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement(
                    "update contact set value=? where RESUME_UUID=? and TYPE=?")) {
                for (Map.Entry<ContactType, String> e : contactsToUpdate.entrySet()) {
                    st.setString(1, e.getValue());
                    st.setString(2, uuid);
                    st.setString(3, e.getKey().name());
                    st.addBatch();
                }
                st.executeBatch();
            }
            return null;
        });
    }

    private void deleteMapContacts(String uuid, Map<ContactType, String> contactsToRemove) throws SQLException {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement("DELETE FROM contact WHERE resume_uuid=? AND type=?")) {
                for (Map.Entry<ContactType, String> e : contactsToRemove.entrySet()) {
                    st.setString(1, uuid);
                    st.setString(2, e.getKey().name());
                    st.addBatch();
                }
                st.executeBatch();
            }
            return null;
        });
    }

    private void addMapContacts(String uuid, Map<ContactType, String> contactsToAdd) throws SQLException {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO contact (resume_uuid, type, value) VALUES (?,?,?)")) {
                for (Map.Entry<ContactType, String> e : contactsToAdd.entrySet()) {
                    st.setString(1, uuid);
                    st.setString(2, e.getKey().name());
                    st.setString(3, e.getValue());
                    st.addBatch();
                }
                st.executeBatch();
            }
            return null;
        });
    }
    @Override
    public void delete(String uuid) {
        sqlHelper.execute("DELETE FROM resume WHERE uuid=?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new ResumeNotFoundException(uuid);
            }
            return null;
        });
    }

    @Override
    public List<Resume> getAllSorted() {
        return sqlHelper.execute("" +
                        "SELECT * FROM resume r\n" +
                        "LEFT JOIN contact c ON r.uuid = c.resume_uuid\n" +
                        "ORDER BY full_name, uuid",
                ps -> {
                    ResultSet rs = ps.executeQuery();
                    Map<String, Resume> map = new LinkedHashMap<>();
                    while (rs.next()) {
                        String uuid = rs.getString("uuid");
//                        map.putIfAbsent()
                        Resume resume = map.get(uuid);
                        if (resume == null) {
                            resume = new Resume(rs.getString("uuid"), rs.getString("full_name"), rs.getString("about"));
                            map.put(uuid, resume);
                        }
                        addContact(rs, resume);
                    }
                    return new ArrayList<>(map.values());
                });
    }

    @Override
    public int size() {
        return sqlHelper.execute("SELECT count(*) FROM resume", st -> {
            ResultSet rs = st.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }

    private void insertContact(Connection conn, Resume r) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO contact (resume_uuid, type, value) VALUES (?,?,?)")) {
            for (Map.Entry<ContactType, String> e : r.getContacts().entrySet()) {
                st.setString(1, r.getUuid());
                st.setString(2, e.getKey().name());
                st.setString(3, e.getValue());
                st.addBatch();
            }
            st.executeBatch();
        }
    }

    private void addContact(ResultSet rs, Resume r) throws SQLException {
        String value = rs.getString("value");
        if (!HtmlUtil.isEmpty(value)) {
            ContactType type = ContactType.valueOf(rs.getString("type"));
            r.addContact(type, value);
        }
    }

    private void deleteContacts(Resume r) throws SQLException {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement("DELETE FROM contact WHERE resume_uuid = ?")) {
                st.setString(1, r.getUuid());
                st.execute();
            }
            return null;
        });
    }
}

