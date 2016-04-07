package ru.javawebinar.webapp.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by arkan on 07.04.2016.
 */
public class ResumeUuidComparator implements Comparator<Resume> {
    @Override
    public int compare(Resume o1, Resume o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        return o1.getUUid().compareTo(o2.getUUid());
    }
}
