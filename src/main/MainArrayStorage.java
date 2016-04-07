package main;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.ArrayStorageImpl;
import ru.javawebinar.webapp.storage.SortedArrayStorageImpl;
import ru.javawebinar.webapp.storage.Storage;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {

    public static void main(String[] args) {
        Resume resume = makeResume();
        String uuid = resume.getUuid();
        Storage storage = new ArrayStorageImpl();
        storage.clear();
        storage.save(resume);

        Resume res1 = storage.get(uuid);
        Resume resume2 = makeResume2();
        storage.save(resume2);

        Storage storageSort = new SortedArrayStorageImpl();
        storageSort.save(resume);
        Resume r2 = storageSort.get(uuid);
        System.out.println(storageSort.size());
        storageSort.delete(uuid);
        System.out.println(storage.size());

    }

    private static Resume makeResume2(){
        Resume r1 = new Resume("П Имя1", "About1");
        r1.addContact(ContactType.EMAILHOME, new Link(null, "mail1@google.ro"));
        r1.addContact(ContactType.CELLPHONE, new Link("11111", null));
        r1.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        List<String> achivementList = Arrays.asList("Achivment11", "Achivment12", "Achivment12");
        r1.addSection(new ListSection(achivementList, SectionType.ACHIEVEMENT));
        List<String> qualifaicationList = Arrays.asList("Java", "SQL");
        r1.addSection(new ListSection(qualifaicationList, SectionType.QUALIFICATIONS));
        r1.addSection(new OrganizationSection(SectionType.EXPERIENCE));
        r1.addSection(new OrganizationSection(SectionType.EDUCATION));

        Date fd = new Date(System.currentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(fd);
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date fd1 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd1 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date fd2 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd2 = gregorianCalendar.getTime();

        OrganizationSection workSection = r1.getOrganizationSection(SectionType.EXPERIENCE);
        workSection.addOrganization(new Organization("Рога Копыта", "www.kapetc.org"), sd, fd, "Президент", "CTO");

        OrganizationSection eduSection = r1.getOrganizationSection(SectionType.EDUCATION);
        eduSection.addOrganization(new Organization("Где-то учился", "www.gu.edu"), sd1, fd1, "Студент", "двоечник");

        workSection.addOrganization(new Organization("Капута", "www.лфзгыеф.org"), sd2, fd2, "Младший помощник", "Старшего дворника");
        return r1;
    }

    private static Resume makeResume(){
        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.EMAILHOME, new Link(null, "mail1@ya.ru"));
        r1.addContact(ContactType.CELLPHONE, new Link("11111", null));
        r1.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        List<String> achivementList = Arrays.asList("Achivment11", "Achivment12", "Achivment12");
        r1.addSection(new ListSection(achivementList, SectionType.ACHIEVEMENT));
        List<String> qualifaicationList = Arrays.asList("Java", "SQL");
        r1.addSection(new ListSection(qualifaicationList, SectionType.QUALIFICATIONS));
        r1.addSection(new OrganizationSection(SectionType.EXPERIENCE));
        r1.addSection(new OrganizationSection(SectionType.EDUCATION));

        Date fd = new Date(System.currentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(fd);
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date fd1 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd1 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date fd2 = gregorianCalendar.getTime();
        gregorianCalendar.add(Calendar.YEAR, -1);
        Date sd2 = gregorianCalendar.getTime();

        OrganizationSection workSection = r1.getOrganizationSection(SectionType.EXPERIENCE);
        workSection.addOrganization(new Organization("Рога Копыта", "www.kapetc.org"), sd, fd, "Президент", "CTO");

        OrganizationSection eduSection = r1.getOrganizationSection(SectionType.EDUCATION);
        eduSection.addOrganization(new Organization("Как будто где-то учился", "www.kbgu.edu"), sd1, fd1, "Студент", "двоечник");

        workSection.addOrganization(new Organization("Рога Копыта", "www.kapetc.org"), sd2, fd2, "Младший помощник", "Старшего дворника");
        return r1;
    }

}
