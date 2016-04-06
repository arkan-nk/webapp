package ru.javawebinar.webapp.model;


/**
 * Created by arkan on 04.04.2016.
 */
public enum ContactType {
    LOCATION("Проживание"), CELLPHONE("Мобильный тел."), EMAILHOME("e-mail"), SKYPE("skype"),
    HOME_PAGE("Homepage"), HABRPROFILE("Habrhabr"), STACKOVFPROFILE("stackoverflow"),
    GITHUBACC("github"), LINKEDLNPROFILE("LinkedIn");

    ContactType(String title1) {
        title = title1;
    }

    public String getTitle() {
        return title;
    }

    private String title;
}