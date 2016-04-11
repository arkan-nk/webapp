package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section implements Comparable<Section> {

    public SectionType getSectionType() {
        return sectionType;
    }

    protected Section(SectionType title) {
        this.sectionType = title;
    }

    private final SectionType sectionType;

    public int compareTo(Section s) {
        return sectionType.compareTo(s.getSectionType());
    }
}
