package ru.javawebinar.webapp.model;

import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class Organization {

    public Link getHomePage() {
        return homePage;
    }

    public void setHomePage(Link homePage) {
        this.homePage = homePage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
    public Organization(Link hp, List<Position> lp){
        homePage=hp;
        positions=lp;
    }
    private Link homePage;
    private List<Position> positions;
}
