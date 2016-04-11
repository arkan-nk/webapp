package ru.javawebinar.webapp.model;

import java.time.LocalDate;
import java.util.*;

/**
 * GKislin
 * 01.04.2016
 */
public class OrganizationSection extends Section {
    public void addOrganization(Organization org, LocalDate sD, LocalDate fD, String t, String d) {
        Objects.requireNonNull(org);
        Organization orgAlreadyHave = searchSameOrganization(org);
        if (orgAlreadyHave == null) {
            organizations.add(org);
            orgAlreadyHave = org;
        }
        orgAlreadyHave.addPosition(sD, fD, t, d);
    }

    private Organization searchSameOrganization(Organization o1) {
        Objects.requireNonNull(o1);
        Organization result = null;
        for (Organization org : organizations) {
            if (org.getHomePage().equals(o1.getHomePage())) {
                result = org;
                break;
            }
        }
        return result;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public OrganizationSection(SectionType title) {
        super(title);
    }

    private List<Organization> organizations = new ArrayList<Organization>();
}
