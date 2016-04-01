package ru.javawebinar.model;

/**
 * Created by arkan on 01.04.2016.
 */
public class Organization {

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    private String orgName;
    private String urlLink;
}
