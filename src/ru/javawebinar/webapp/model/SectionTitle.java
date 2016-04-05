package ru.javawebinar.webapp.model;

/**
 * Created by arkan on 04.04.2016.
 */
public enum SectionTitle {
    OBJECTIVE("Позиция", SectionType.ONELINE),
    ACHIEVEMENT("Достижения", SectionType.MULTILINE),
    QUALIFICATIONS("Квалификация", SectionType.MULTILINE),
    EXPERIENCE("Опыт работы", SectionType.ORGANIZATION),
    EDUCATION("Образование", SectionType.ORGANIZATION);

    SectionTitle(String text, SectionType st) {
        title = text;
        type = st;
    }

    public String getTitle() {
        return title;
    }

    private String title;
    private SectionType type;
}
