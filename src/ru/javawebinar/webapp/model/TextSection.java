package ru.javawebinar.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {

    public void setContent(String c) {
        content = c;
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "content='" + content + '\'' +
                '}';
    }

    public TextSection(String content, SectionType title) {
        super(title);
        this.content = content;
    }

    private String content;
}
