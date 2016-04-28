package ru.javawebinar.webapp.web;

import ru.javawebinar.webapp.model.*;

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
    public Section getPositionSection(){
        return resume.getSections().get(SectionType.OBJECTIVE);
    }
    public List<String> getLinesSection(SectionType st){
        ListSection sect = (ListSection) resume.getSections().get(st);
        return sect.getLines();
    }
}
