package ru.javawebinar.webapp.model;

/**
 * Created by arkan on 04.04.2016.
 */
public enum ContactType {
    LOCATION (0,"Проживание"), CELLPHONE(1, "Тел."), EMAILHOME(2, "e-mail"), SKYPE(3, "skype"),
    HABRPROFILE(4, "Habrhabr"), STACKOVFPROFILE(5, "stackoverflow"), GITHUBACC(6, "github"),
    LINKEDLNPROFILE(7,"LinkedIn");

    ContactType(Integer idd, String caption1){
        id=idd;
        caption = caption1;
    }
    public String getCaption(){
        return caption;
    }
    public Integer getId(){
        return id;
    }
    private String caption;
    private Integer id;
}
