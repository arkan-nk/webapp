package ru.javawebinar.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    private List<String> lines = new ArrayList<>();

    public ListSection(String... lines) {
        this(Arrays.asList(lines));
    }

    public ListSection(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
