package ru.javawebinar.webapp.model;

import java.util.Date;

/**
 * GKislin
 * 01.04.2016
 */
public class Position {
    public String getDescription() {
        return description;
    }


    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public String getTitle() {
        return title;
    }

    public Position(Date s, Date e, String t, String d) {
        startDate = s;
        endDate = e;
        title = t;
        description = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (!getStartDate().equals(position.getStartDate())) return false;
        if (!getEndDate().equals(position.getEndDate())) return false;
        if (!getTitle().equals(position.getTitle())) return false;
        return getDescription() != null ? getDescription().equals(position.getDescription()) : position.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getStartDate().hashCode();
        result = 31 * result + getEndDate().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    private Date startDate;
    private Date endDate;
    private String title;
    private String description;
}
