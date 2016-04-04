package ru.javawebinar.webapp.model;

/**
 * Created by arkan on 04.04.2016.
 */
public enum SectionTitle {
    OBJECTIVE ("Позиция"), ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"), EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");
    SectionTitle(String text){
        title=text;
    }
    public String getTitle(){
        return title;
    }
    private String title;
}
