package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {
    public List<Organization> getOrganizations(){
        return organizations;
    }
    public void setOrganizations(List<Organization> o){
        organizations=o;
    }
    public OrganizationSection(List<Organization> organizations) {
        super(SectionType.ORGANIZATION);
        this.organizations = organizations;
    }
    private List<Organization> organizations;
}
