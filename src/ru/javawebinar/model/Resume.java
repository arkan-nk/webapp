package ru.javawebinar.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by arkan on 01.04.2016.
 */
public class Resume {
    public Map<String, String> getQualification() {
        return qualification;
    }

    public void setQualification(Map<String, String> qualification) {
        this.qualification = qualification;
    }

    public Set<String> getAchievement() {
        return achievement;
    }

    public void setAchievement(Set<String> achievement) {
        this.achievement = achievement;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
    public List<JobExperience> getExperience() {
        return experience;
    }

    public void setExperience(List<JobExperience> experience) {
        this.experience = experience;
    }

    public List<EducationExperience> getEducation() {
        return education;
    }

    public void setEducation(List<EducationExperience> education) {
        this.education = education;
    }

    private Contact contact;
    private List<String> links;
    private String fullName;
    private String objective;
    private Set<String> achievement;
    private Map<String,String> qualification;
    private List<JobExperience> experience;
    private List<EducationExperience> education;
}
