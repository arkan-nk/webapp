package ru.javawebinar.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    @Override
    public List<String> getContent() {
        return Arrays.asList(content);
    }

    public void setContent(String c) {
        content = c;
    }

    public TextSection(String content, SectionTitle title) {
        super(title);
        this.content = content;
    }

    private String content;
}
