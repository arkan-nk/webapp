package ru.javawebinar.webapp.model;

import java.util.*;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume implements Comparable {
    private final String uuid;
    private String fullName;
    private String about;
    private Map<ContactType, Contact> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName, String about) {
        this(UUID.randomUUID().toString(), fullName, about);
    }

    public Resume(String uuid, String fullName, String about) {
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.about = about;
    }

    public String getUuid() {
        return uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addContact(ContactType type, String value) {
        contacts.put(type, new Contact(type, value));
    }

    public void addSection(Section section) {
        sections.put(section.type, section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (about != null ? !about.equals(resume.about) : resume.about != null) return false;
        if (!contacts.equals(resume.contacts)) return false;
        return sections.equals(resume.sections);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + contacts.hashCode();
        result = 31 * result + sections.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resume{" + uuid + ", " +
                "fullName='" + fullName + '\'' + ", about='" + about + "\n," +
                "contacts=" + contacts + "\n," +
                "sections=" + sections +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Resume other = (Resume) o;
        int cmp = fullName.compareTo(other.fullName);
        return cmp == 0 ? uuid.compareTo(other.uuid) : cmp;
    }
}
