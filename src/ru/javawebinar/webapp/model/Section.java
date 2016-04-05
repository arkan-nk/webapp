package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public abstract class Section {
    //TODO it's need refactoring because
    // OrganizationSection has sophisticated structure
    // List<String> can't satisfy it
    public abstract List<String> getContent();

    public SectionTitle getSectionTitle() {
        return title;
    }

    protected Section(SectionTitle title) {
        this.title = title;
    }

    private final SectionTitle title;
}
