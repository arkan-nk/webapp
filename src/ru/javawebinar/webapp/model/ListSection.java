package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {

    public void setLines(List<String> ll) {
        lines = ll;
    }

    public ListSection(List<String> ls, SectionType title) {
        super(title);
        lines = ls;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "lines=" + lines.toString() +
                '}';
    }

    private List<String> lines;
}
