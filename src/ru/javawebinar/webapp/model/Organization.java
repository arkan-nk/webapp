package ru.javawebinar.webapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 01.04.2016
 */
public class Organization{
    public void addPosition(Date sDate, Date eDate, String pos, String descr) {
        positions.add(new Position(sDate, eDate, pos, descr));
    }

    public Link getHomePage() {
        return homePage;
    }


    public List<Position> getPositions() {
        return positions;
    }

    public Organization(String name1, String url1){
        this(new Link(name1, url1));
    }

    public Organization(Link hp) {
        homePage = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return positions.equals(that.positions);

    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", positions=" + positions +
                '}';
    }

    private Link homePage;
    private List<Position> positions = new ArrayList<Position>();
}
