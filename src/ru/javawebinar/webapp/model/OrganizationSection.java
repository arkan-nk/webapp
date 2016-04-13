package ru.javawebinar.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {

    private final List<Organization> organizations;

    public OrganizationSection(SectionType type, Organization... organizations) {
        this(type, Arrays.asList(organizations));
    }

    public OrganizationSection(SectionType type, List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return type + "(" + organizations.toString() + ')';
    }

}
