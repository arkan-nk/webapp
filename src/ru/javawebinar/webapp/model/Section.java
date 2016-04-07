package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section implements Comparable<Section> {

    public SectionType getSectionTitle() {
        return title;
    }

    protected Section(SectionType title) {
        this.title = title;
    }

    private final SectionType title;

    public int compareTo(Section s) {
        return title.compareTo(s.getSectionTitle());
    }
}
