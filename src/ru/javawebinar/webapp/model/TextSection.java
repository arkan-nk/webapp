package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    private String content;

    public TextSection(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
