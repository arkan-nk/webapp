package ru.javawebinar.webapp.model;

import java.util.Comparator;

/**
 * Created by arkan on 07.04.2016.
 */
public class ResumeFullNameComparator implements Comparator<Resume> {
    @Override
    public int compare(Resume o1, Resume o2) {
        return o1.compareTo(o2);
    }
}