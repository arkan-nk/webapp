package main;

import ru.javawebinar.webapp.model.*;

import java.time.Month;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {
    public static void main(String[] args) {
        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.MAIL, "mail1@ya.ru");
        r1.addContact(ContactType.PHONE, "11111");
        r1.addSection(new TextSection(SectionType.OBJECTIVE, "Objective1"));
        r1.addSection(new ListSection(SectionType.ACHIEVEMENT, "Achivment11", "Achivment12", "Achivment12"));
        r1.addSection(new ListSection(SectionType.QUALIFICATIONS, "Java", "SQL"));
        r1.addSection(
                new OrganizationSection(SectionType.EXPERIENCE,
                        new Organization("Organization11", null,
                                new Position(2005, Month.JANUARY, "position1", "content1"),
                                new Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        r1.addSection(
                new OrganizationSection(SectionType.EDUCATION,
                        new Organization("Institute", null,
                                new Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        System.out.println(r1.toString());
    }
}
