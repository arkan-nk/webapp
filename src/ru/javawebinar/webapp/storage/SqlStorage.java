package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.ContactType;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.sql.ConnectionFactory;
import ru.javawebinar.webapp.util.HtmlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * GKislin
 * http://javawebinar.ru/basejava/
 */
public class SqlStorage implements Storage {
    public final ConnectionFactory connectionFactory;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume")) {
            ps.execute();
        } catch (SQLException e) {
            throw new ResumeStorageException(e);
        }
    }

    @Override
    public Resume get(String uuid) {
        try (Connection conn = connectionFactory.getConnection();

             PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume r\n" +
                     " LEFT JOIN  contact c ON r.uuid = c.resume_uuid\n" +
                     " WHERE uuid = ?")) {

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
        } catch (SQLException e) {
            throw new ResumeStorageException(e);
        }
    }

    @Override
    public void save(Resume r) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (uuid, full_name, about) VALUES(?,?,?)")) {

            ps.setString(1, r.getUuid());
            ps.setString(2, r.getFullName());
            ps.setString(3, r.getAbout());
            ps.execute();
            insertContact(conn, r);

        } catch (SQLException e) {
            throw new ResumeStorageException(e);
        }
    }

    @Override
    public void update(Resume r) {
        //TODO
    }

    @Override
    public void delete(String uuid) {
        //TODO
    }

    @Override
    public List<Resume> getAllSorted() {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM resume r\n" +
                             "LEFT JOIN contact c ON r.uuid = c.resume_uuid\n" +
                             "ORDER BY full_name, uuid")) {

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
        } catch (SQLException e) {
            throw new ResumeStorageException(e);
        }
    }

    @Override
    public int size() {
        // TODO
        return 0;
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
}
