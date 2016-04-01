package ru.javawebinar.model;

/**
 * Created by arkan on 01.04.2016.
 */
public class Contact {

    public String getLocation() {
        return location;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getSkype() {
        return skype;
    }

    public String getEmail() {
        return email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String location;
    private String phoneNum;
    private String skype;
    private String email;
}
