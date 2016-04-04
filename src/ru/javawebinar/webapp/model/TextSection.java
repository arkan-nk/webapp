package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 01.04.2016
 */
public class TextSection extends Section {
    private String content;

    protected TextSection(String content) {
        super("TextSection");
        this.content = content;
    }
}
