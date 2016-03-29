package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 29.03.2016
 */
public class Link {
    String name;
    String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
