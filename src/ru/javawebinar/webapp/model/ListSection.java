package ru.javawebinar.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    private static final long serialVersionUID = 1L;

    private List<String> lines = new ArrayList<>();

    public ListSection() {
    }

    public ListSection(String... lines) {
        this(Arrays.asList(lines));
    }

    public ListSection(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
