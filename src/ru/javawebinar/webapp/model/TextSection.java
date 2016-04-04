package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    public String getContent(){
        return content;
    }
    public void setContent(String c){
        content = c;
    }
    protected TextSection(String content) {
        super(SectionType.ONELINE);
        this.content = content;
    }
    private String content;
}
