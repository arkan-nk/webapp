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

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;
}
