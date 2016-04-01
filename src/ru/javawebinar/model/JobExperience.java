package ru.javawebinar.model;

import java.util.Date;
import java.util.List;

/**
 * Created by arkan on 01.04.2016.
 */
public class JobExperience {
    public List<String> getAchievement() {
        return achievement;
    }

    public void setAchievement(List<String> achievement) {
        this.achievement = achievement;
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

    public Organization getJobOrg() {
        return jobOrg;
    }

    public void setOrgName(Organization o1) {
        this.jobOrg = o1;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    private Date startDate;
    private Date endDate;
    private Organization jobOrg;
    private String objective;
    private List<String> achievement;
}
