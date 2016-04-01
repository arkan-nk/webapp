package ru.javawebinar.model;
import java.util.Map;
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
    public Map<String,String> getSocialNetLinks(){
        return socialNetLinks;
    }
    public void setSocialNetLinks(Map<String,String> nl){
        socialNetLinks = nl;
    }
    private String location;
    private String phoneNum;
    private String skype;
    private String email;
    private Map<String,String> socialNetLinks;
}
