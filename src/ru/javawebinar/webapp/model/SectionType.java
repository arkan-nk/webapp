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
        kind = st;
    }


    public String getTitle() {
        return title;
    }

    public SectionKind getKind() {
        return kind;
    }

    private String title;
    private SectionKind kind;
}
