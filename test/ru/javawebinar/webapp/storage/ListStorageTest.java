package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Created by arkan on 14.04.2016.
 */
public class ListStorageTest extends AbstractStorageTest<ListStorage>{
    public ListStorageTest(){
        super(new ListStorage(new ArrayList<Resume>()));
    }
}
