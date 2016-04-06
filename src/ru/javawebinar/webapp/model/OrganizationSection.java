package ru.javawebinar.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> o) {
        organizations = o;
    }

    public OrganizationSection(List<Organization> organizations, SectionType title) {
        super(title);
        this.organizations = organizations;
    }

    private List<Organization> organizations;
}
