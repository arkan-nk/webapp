package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section {
    public abstract List<String> getContent();
    public SectionTitle getSectionTitle(){
        return title;
    }
    public SectionType getSectionType(){
        return type;
    }
    protected Section(SectionType type, SectionTitle title) {
        this.type = type;
        this.title = title;
    }
    private final SectionType type;
    private final SectionTitle title;
}
