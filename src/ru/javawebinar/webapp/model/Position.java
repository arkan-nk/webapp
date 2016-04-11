package ru.javawebinar.webapp.model;

import java.time.LocalDate;
import java.time.Month;

/**
 * GKislin
 * 01.04.2016
 */
public class Position {
    public Position(int year, Month month, String position1, String content1) {
        this(LocalDate.of(year, month, 1), LocalDate.now(), position1, content1);
    }

    public Position(int year1, Month month1, int year2, Month month2, String position1, String content1) {
        this(LocalDate.of(year1, month1, 1), LocalDate.of(year2, month2, 1), position1, content1);
    }

    public String getDescription() {
        return description;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public String getTitle() {
        return title;
    }

    public Position(LocalDate s, LocalDate e, String t, String d) {
        startDate = s;
        endDate = e;
        title = t;
        description = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!title.equals(position.title)) return false;
        if (!startDate.equals(position.startDate)) return false;
        if (endDate != null ? !endDate.equals(position.endDate) : position.endDate != null) return false;
        return description != null ? description.equals(position.description) : position.description == null;

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
