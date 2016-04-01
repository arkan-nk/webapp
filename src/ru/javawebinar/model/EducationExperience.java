package ru.javawebinar.model;

import java.util.Date;

/**
 * Created by arkan on 01.04.2016.
 */
public class EducationExperience {

    public Organization getEducationOrg() {
        return educationOrg;
    }

    public void setEducationOrg(Organization o1) {
        this.educationOrg = o1;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private Organization educationOrg;
    private Date startDate;
    private Date endDate;
    private String description;
}
