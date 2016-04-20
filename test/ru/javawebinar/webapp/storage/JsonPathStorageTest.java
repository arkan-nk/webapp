package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.Config;

/**
 * GKislin
 * 01.11.2015.
 */
public class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
        super(new JsonFileStorage(Config.STORAGE));
    }
}
