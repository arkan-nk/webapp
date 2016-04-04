package ru.javawebinar.webapp.model;

/**
 * Created by arkan on 04.04.2016.
 */
public enum ContactType {
    LOCATION (0,"Проживание"), CELLPHONE(1, "Тел."), EMAILHOME(2, ""), SKYPE(3, ""),
    HABRPROFILE(4, ""), STACKOVFPROFILE(5, ""), GITHUBACC(6, ""), LINKEDLNPROFILE(7,"");

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
