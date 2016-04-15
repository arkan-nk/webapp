package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.TreeMap;

/**
 * Created by arkan on 14.04.2016.
 */
public class MapStorageTest extends AbstractStorageTest<MapStorage>{
    public MapStorageTest(){
        super(new MapStorage(new TreeMap<String, Resume>()));
    }
}
