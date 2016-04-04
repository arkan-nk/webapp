package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class ListSection extends Section {
    public List<String> getLines(){
        return lines;
    }
    public void setLines(List<String> ll){
        lines=ll;
    }
    public ListSection(List<String> ls){
        super(SectionType.MULTILINE);
        lines =ls;
    }

    private List<String> lines;
}
