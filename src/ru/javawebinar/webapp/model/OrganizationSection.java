package ru.javawebinar.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {
    @Override //TODO need to implements correctly
    public List<String> getContent(){
        return Arrays.asList(organizations.toString());
    }
    public List<Organization> getOrganizations(){
        return organizations;
    }
    public void setOrganizations(List<Organization> o){
        organizations=o;
    }
    public OrganizationSection(List<Organization> organizations, SectionTitle title) {
        super(SectionType.ORGANIZATION, title);
        this.organizations = organizations;
    }
    private List<Organization> organizations;
}
