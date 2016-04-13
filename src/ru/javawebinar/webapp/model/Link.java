package ru.javawebinar.webapp.model;

/**
 * GKislin
 * 29.03.2016
 */
public class Link {
    private static final long serialVersionUID = 1L;

    private String name;
    private String url;

    public Link() {
    }

    public Link(Link link) {
        this(link.name, link.url);
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link(" + name + ',' + url + ')';
    }
}
