package ru.javawebinar.webapp.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * GKislin
 * 29.03.2016
 */
public class Resume {
    public String getFullName(){
        return fullName;
    }
    public String getAbout(){
        return about;
    }
    public List<Contact> getContacts(){
        return contacts;
    }
    public List<Section> getSection(){
        return sections;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    private String fullName;
    private String about;
    private List<Contact> contacts;
    private List<Section> sections;
}
