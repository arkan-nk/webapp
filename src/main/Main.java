package main;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.MapStorageImpl;
import ru.javawebinar.webapp.storage.Storage;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

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
        Resume resume = new Resume();
        resume.setFullName("Василий Чапаев");
        resume.setAbout("персонаж");
        Map<ContactType, Contact> contactMap = new EnumMap<ContactType, Contact>(ContactType.class);
        contactMap.put(ContactType.LOCATION, new Contact(ContactType.LOCATION, new Link("Дно реки Урал", null)));
        contactMap.put(ContactType.CELLPHONE, new Contact(ContactType.CELLPHONE, new Link("Motorolla RAZR V3", null)));
        contactMap.put(ContactType.EMAILHOME, new Contact(ContactType.EMAILHOME, new Link("", "zhena@jizni.net")));
        resume.setContacts(contactMap);
        Map<SectionTitle, Section> sectionMap = new EnumMap<SectionTitle, Section>(SectionTitle.class);
        sectionMap.put(SectionTitle.OBJECTIVE, new TextSection("Командующий дивизией", SectionTitle.OBJECTIVE));
        resume.setSections(sectionMap);

        System.out.println(resume.getFullName());
        System.out.println(resume.getAbout());

        Contact emailContact = resume.getContacts().get(ContactType.EMAILHOME);
        System.out.println(emailContact.getContactType().getCaption() + ":" + emailContact.getValue().getUrl());
        for (String contentLine : resume.getSection().get(SectionTitle.OBJECTIVE).getContent()) {
            System.out.println(contentLine);
        }
        /*
        Link link = new Link("name", "url");
        link.setName("name2");
        link.setUrl("ulr2");
        System.out.println(link.toString());
        System.out.println(link.getName());
        */
        Storage storage = new MapStorageImpl();
        storage.getClass();
    }
}
