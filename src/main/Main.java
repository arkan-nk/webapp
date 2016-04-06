package main;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.MapStorageImpl;
import ru.javawebinar.webapp.storage.Storage;

import java.util.EnumMap;
import java.util.Map;

/**
 * User: gkislin
 * Date: 18.06.2014
 */
public class Main {
    /**
     * First java program
     *
     * @param args : program arguments
     */
    public static void main(String[] args) {
        Resume resume = new Resume("Василий Чапаев", "персонаж");
        Map<ContactType, Contact> contactMap = new EnumMap<ContactType, Contact>(ContactType.class);
        contactMap.put(ContactType.LOCATION, new Contact(ContactType.LOCATION, new Link("Дно реки Урал", null)));
        contactMap.put(ContactType.CELLPHONE, new Contact(ContactType.CELLPHONE, new Link("Motorolla RAZR V3", null)));
        contactMap.put(ContactType.EMAILHOME, new Contact(ContactType.EMAILHOME, new Link("", "zhena@jizni.net")));
        resume.addContact(ContactType.LOCATION, new Link("Дно реки Урал", null));
        resume.addContact(ContactType.CELLPHONE, new Link("Motorolla RAZR V3", null));
        resume.addContact(ContactType.EMAILHOME, new Link("", "zhena@jizni.net"));
        Map<SectionType, Section> sectionMap = new EnumMap<SectionType, Section>(SectionType.class);
        resume.addSection(new TextSection("Командующий дивизией", SectionType.OBJECTIVE));

        System.out.println(resume.getFullName());
        System.out.println(resume.getAbout());
        /*
        Contact emailContact = resume.getContacts().get(ContactType.EMAILHOME);
        System.out.println(emailContact.getContactType().getTitle() + ":" + emailContact.getValue().getUrl());
        for (String contentLine : resume.getSection().get(SectionType.OBJECTIVE).getContent()) {
            System.out.println(contentLine);
        }
        /*
        Storage storage = new MapStorageImpl();
        storage.getClass();
        */
    }
}
