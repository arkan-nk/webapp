package main;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.ArrayStorageImpl;
import ru.javawebinar.webapp.storage.SortedArrayStorageImpl;
import ru.javawebinar.webapp.storage.Storage;
import ru.javawebinar.webapp.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class MainArrayStorage {

    public static void main(String[] args) {
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
        LocalDate sd2 = DateUtil.of(2001, Month.DECEMBER);
        LocalDate fd2 = DateUtil.of(2005, Month.SEPTEMBER);
        LocalDate sd1 = DateUtil.of(2005, Month.DECEMBER);
        LocalDate fd1 = DateUtil.of(2009, Month.JANUARY);
        LocalDate sd = DateUtil.of(2009, Month.FEBRUARY);
        LocalDate fd = DateUtil.of(2013, Month.DECEMBER);
        OrganizationSection workSection = r1.getOrganizationSection(SectionType.EXPERIENCE);
        workSection.addOrganization(new Organization("Рога Копыта", "www.kapetc.org"), new Position(sd, fd, "Президент", "CTO"));

        OrganizationSection eduSection = r1.getOrganizationSection(SectionType.EDUCATION);
        eduSection.addOrganization(new Organization("Как будто где-то учился", "www.kbgu.edu"), new Position(sd1, fd1, "Студент", "двоечник"));

        workSection.addOrganization(new Organization("Рога Копыта", "www.kapetc.org"), new Position(sd2, fd2, "Младший помощник", "Старшего дворника"));
    }
}
