package ru.javawebinar.webapp.web;

import ru.javawebinar.webapp.model.*;

import java.util.Collections;
import java.util.List;

import static ru.javawebinar.webapp.Config.STORAGE;

/**
 * Created by arkan on 28.04.2016.
 */
public class ResumeBean {
    private Resume resume;
    public void setUuid(String uuid1){
        resume = STORAGE.get(uuid1);
    }
    public Resume getResume(){
        return resume;
    }
    public ContactType[] getContactTypes(){
        return ContactType.values();
    }
    public SectionType[] getSectionTypes(){
        return SectionType.values();
    }
    public Section getTextSection(SectionType lineSectionType){
        return resume.getSections().get(lineSectionType);
    }
    public List<String> getLinesSection(SectionType st){
        ListSection sect = (ListSection) resume.getSections().get(st);
        return sect!=null ? sect.getLines() : Collections.emptyList();
    }
    public List<Organization> getOrganizations(SectionType orgSection){
        OrganizationSection os = (OrganizationSection) resume.getSections().get(orgSection);
        if (os==null) return Collections.emptyList();
        List<Organization> listOrganization = os.getOrganizations();
        return listOrganization;
    }
    public List<Organization.Position> getOrganizationPositionList(SectionType orgSection, int indexOrganization){
        OrganizationSection os = (OrganizationSection) resume.getSections().get(orgSection);
        if (os==null) return Collections.emptyList();
        Organization org = os.getOrganizations().get(indexOrganization);
        return org.getPositions();
    }
}
