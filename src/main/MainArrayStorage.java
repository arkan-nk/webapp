package main;

import ru.javawebinar.webapp.model.*;

import java.util.Arrays;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {
    // TODO add OrganizationSection
    public static void main(String[] args) {
        Resume r1 = new Resume("Полное Имя1", "About1");
        r1.addContact(ContactType.EMAILHOME, new Link(null,"mail1@ya.ru"));
        r1.addContact(ContactType.CELLPHONE, new Link("11111",null));
        r1.addSection(new TextSection("Objective1", SectionType.OBJECTIVE));
        r1.addSection(new ListSection(Arrays.asList("Achivment11", "Achivment12", "Achivment12"), SectionType.ACHIEVEMENT));
        r1.addSection(new ListSection(Arrays.asList("Java", "SQL"), SectionType.QUALIFICATIONS));

        // TODO test ArrayStorageImpl
    }
}
