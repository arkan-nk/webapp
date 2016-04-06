package ru.javawebinar.webapp.model;

/**
 * Created by arkan on 04.04.2016.
 */
public enum SectionType {
    OBJECTIVE("Позиция", SectionKind.ONELINE),
    ACHIEVEMENT("Достижения", SectionKind.MULTILINE),
    QUALIFICATIONS("Квалификация", SectionKind.MULTILINE),
    EXPERIENCE("Опыт работы", SectionKind.ORGANIZATION),
    EDUCATION("Образование", SectionKind.ORGANIZATION);

    SectionType(String text, SectionKind st) {
        title = text;
        type = st;
    }


    public String getTitle() {
        return title;
    }

    public SectionKind getType() {
        return type;
    }

    private String title;
    private SectionKind type;
}
