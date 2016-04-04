package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section {

    public SectionType getSectionType(){
        return type;
    }
    protected Section(SectionType type) {
        this.type = type;
    }
    private final SectionType type;
}
