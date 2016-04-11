package ru.javawebinar.webapp.model;

import java.util.*;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {

    public OrganizationSection getOrganizationSection(SectionType st) {
        Collections.sort(sections, new SectionComapartor());
        Section section = new OrganizationSection(st);
        int index = Collections.binarySearch(sections, section);
        if (index < 0) return null;
        return (OrganizationSection) sections.get(index);
    }

    public void addContact(ContactType type, Link value) {
        contacts.add(new Contact(type, value));
    }

    public void addSection(Section section) {
        sections.add(section);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);

    }


    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    public Resume(String fN, String ab) {
        this(UUID.randomUUID(), fN, ab);
    }

    public Resume(UUID uuid1, String fN, String ab) {
        Objects.requireNonNull(uuid1, "UUID must not be null");
        Objects.requireNonNull(fN, "fullName must not be null");
        uuid = uuid1;
        fullName = fN;
        about = ab;
        contacts = new ArrayList<>();
        sections = new ArrayList<>();
    }
    public UUID getUUid(){
        return uuid;
    }
    public String getUuid(){
        return uuid.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbout() {
        return about;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Section> getSection() {
        return sections;
    }


    private final UUID uuid;
    private String fullName;
    private String about;
    private List<Contact> contacts;
    private List<Section> sections;

    //private Map<ContactType, Contact> contacts;
    //private Map<SectionType, Section> sections;
}
