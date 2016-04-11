package ru.javawebinar.webapp;

import ru.javawebinar.webapp.model.*;

import java.time.Month;
import java.util.Arrays;

/**
 * GKislin
 * 30.10.2015.
 */
public class ResumeTestData {
    public static Resume R1;
    public static Resume R2;
    public static Resume R3;

    public static void init() {
        R1 = new Resume("Полное Имя1", "About1");
        R2 = new Resume("Полное Имя2", "About2");
        R3 = new Resume("Полное Имя3", "About3");
        R1.addContact(ContactType.EMAILHOME, new Link(null, "mail1@ya.ru"));
        R1.addContact(ContactType.CELLPHONE, new Link("11111", null));
        R1.addContact(ContactType.SKYPE, new Link(null, "skype1"));
        R1.addContact(ContactType.HABRPROFILE, new Link(null, "22221"));
        R1.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        R1.addSection(new ListSection(Arrays.asList("Achivment11", "Achivment12"), SectionType.ACHIEVEMENT));
        R1.addSection(new ListSection(Arrays.asList("Java", "SQL"), SectionType.QUALIFICATIONS));
        OrganizationSection os1 = new OrganizationSection(SectionType.EXPERIENCE);
        os1.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2005, Month.JANUARY, "position2", "content2"));
        os1.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2001, Month.MARCH, 2004, Month.DECEMBER, "position1", "content1"));
        OrganizationSection os2 = new OrganizationSection(SectionType.EDUCATION);
        os2.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1996, Month.SEPTEMBER, 2001, Month.MAY, "student2", null));
        os2.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1990, Month.SEPTEMBER, 1996, Month.JUNE, "student1", "computer science"));
        R1.addSection(os1);
        R1.addSection(os2);

        R2.addContact(ContactType.EMAILHOME, new Link(null, "mail2@ya.ru"));
        R2.addContact(ContactType.CELLPHONE, new Link("11112", null));
        R2.addContact(ContactType.SKYPE, new Link(null, "skype2"));
        R2.addContact(ContactType.HABRPROFILE, new Link(null, "22222"));
        R2.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        R2.addSection(new ListSection(Arrays.asList("Achivment11", "Achivment12"), SectionType.ACHIEVEMENT));
        R2.addSection(new ListSection(Arrays.asList("Java", "SQL"), SectionType.QUALIFICATIONS));
        OrganizationSection os3 = new OrganizationSection(SectionType.EXPERIENCE);
        os3.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2005, Month.JANUARY, "position2", "content2"));
        os3.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2001, Month.MARCH, 2004, Month.DECEMBER, "position1", "content1"));
        OrganizationSection os4 = new OrganizationSection(SectionType.EDUCATION);
        os4.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1996, Month.SEPTEMBER, 2001, Month.MAY, "student2", null));
        os4.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1990, Month.SEPTEMBER, 1996, Month.JUNE, "student1", "computer science"));
        R2.addSection(os3);
        R2.addSection(os4);
        //UUID1 = R1.getUuid();
        R3.addContact(ContactType.EMAILHOME, new Link(null, "mail3@ya.ru"));
        R3.addContact(ContactType.CELLPHONE, new Link("11111", null));
        R3.addContact(ContactType.SKYPE, new Link(null, "skype3"));
        R3.addContact(ContactType.HABRPROFILE, new Link(null, "22223"));
        R3.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        R3.addSection(new ListSection(Arrays.asList("Achivment11", "Achivment12"), SectionType.ACHIEVEMENT));
        R3.addSection(new ListSection(Arrays.asList("Java", "SQL"), SectionType.QUALIFICATIONS));
        OrganizationSection os5 = new OrganizationSection(SectionType.EXPERIENCE);
        os3.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2005, Month.JANUARY, "position2", "content2"));
        os3.addOrganization(new Organization("Organization11", "www.roga-kopyta.com"), new Position(2001, Month.MARCH, 2004, Month.DECEMBER, "position1", "content1"));
        OrganizationSection os6 = new OrganizationSection(SectionType.EDUCATION);
        os4.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1996, Month.SEPTEMBER, 2001, Month.MAY, "student2", null));
        os4.addOrganization(new Organization("Institute", "www.kbgu.com"), new Position(1990, Month.SEPTEMBER, 1996, Month.JUNE, "student1", "computer science"));
        R3.addSection(os5);
        R3.addSection(os6);

    }
}
