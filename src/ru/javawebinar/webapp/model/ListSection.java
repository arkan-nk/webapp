package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    @Override
    public List<String> getContent() {
        return lines;
    }

    public void setLines(List<String> ll) {
        lines = ll;
    }

    public ListSection(List<String> ls, SectionTitle title) {
        super(title);
        lines = ls;
    }

    private List<String> lines;
}
