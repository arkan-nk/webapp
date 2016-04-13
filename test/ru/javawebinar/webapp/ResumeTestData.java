package ru.javawebinar.webapp;

import ru.javawebinar.webapp.model.*;

import java.time.Month;

/**
 * GKislin
 * 30.10.2015.
 */
public class ResumeTestData {
    public static Resume R1;
    public static Resume R2;
    public static Resume R3;

    public static String UUID1;

    public static void init() {
        R1 = new Resume("Полное Имя1", "About1");
        R2 = new Resume("Полное Имя2", "About2");
        R3 = new Resume("Полное Имя3", "About3");
        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");

        R1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective1"));
        R1.addSection(new ListSection(SectionType.ACHIEVEMENT, "Achivment11", "Achivment12"));
        R1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));
        R1.addSection(
                new OrganizationSection(SectionType.EXPERIENCE,
                        new Organization("Organization11", null,
                                new Position(2005, Month.JANUARY, "position1", "content1"),
                                new Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(
                new OrganizationSection(SectionType.EDUCATION,
                        new Organization("Institute", null,
                                new Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        UUID1 = R1.getUuid();
    }
}
