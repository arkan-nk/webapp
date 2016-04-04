package main;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.MapStorageImpl;
import ru.javawebinar.webapp.storage.Storage;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

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
        Contact[] contactArray = new Contact[]{
            new Contact(ContactType.LOCATION, new Link("Дно реки Урал",null)),
            new Contact(ContactType.CELLPHONE, new Link("Motorolla RAZR V3",null)),
            new Contact(ContactType.EMAILHOME, new Link("", "zhena@jizni.net"))
        };
        List<Contact> contactList = Arrays.asList(contactArray);
        resume.setContacts(contactList);
        Section[] sectionArray = new Section[]{
            new TextSection("Командующий дивизией", SectionTitle.OBJECTIVE)
        };
        List<Section> sectionList= asList(sectionArray);
        resume.setSections(sectionList);

        System.out.println(resume.getFullName());
        System.out.println(resume.getAbout());

        for (Contact contactIt : resume.getContacts()){
            if (contactIt.getContactType()==ContactType.EMAILHOME) {
                System.out.println(contactIt.getContactType().getCaption() + ": " + contactIt.getValue().getUrl());
                break;
            }
        }
        for (Section sect : resume.getSection()){
            if (sect.getSectionType()==SectionType.ONELINE && sect.getSectionTitle()==SectionTitle.OBJECTIVE){
                System.out.print(sect.getSectionTitle().getTitle() + ": ");
                for (String str : sect.getContent()) {
                    System.out.println(str);
                }
                break;
            }
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
