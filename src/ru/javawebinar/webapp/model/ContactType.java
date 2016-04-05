package ru.javawebinar.webapp.model;


/**
 * Created by arkan on 04.04.2016.
 */
public enum ContactType {
    LOCATION("Проживание"), CELLPHONE("Тел."), EMAILHOME("e-mail"), SKYPE("skype"),
    HABRPROFILE("Habrhabr"), STACKOVFPROFILE("stackoverflow"), GITHUBACC("github"),
    LINKEDLNPROFILE("LinkedIn");

    ContactType(String caption1) {
        caption = caption1;
    }

    public String getCaption() {
        return caption;
    }

    private String caption;
}