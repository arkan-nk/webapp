package ru.javawebinar.webapp.model;

import java.util.Comparator;

/**
 * Created by arkan on 07.04.2016.
 */
class SectionComapartor implements Comparator<Section>{
    @Override
    public int compare(Section o1, Section o2) {
        return o1.compareTo(o2);
    }
}
