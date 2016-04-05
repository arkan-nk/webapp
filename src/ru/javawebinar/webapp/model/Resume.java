package ru.javawebinar.webapp.model;

import java.util.Map;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {
    public String getFullName() {
        return fullName;
    }

    public String getAbout() {
        return about;
    }

    public Map<Integer, Contact> getContacts() {
        return contacts;
    }

    public Map<Integer, Section> getSection() {
        return sections;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setContacts(Map<Integer, Contact> contacts) {
        this.contacts = contacts;
    }

    public void setSections(Map<Integer, Section> sections) {
        this.sections = sections;
    }

    private String fullName;
    private String about;
    private Map<Integer, Contact> contacts;
    private Map<Integer, Section> sections;
}
