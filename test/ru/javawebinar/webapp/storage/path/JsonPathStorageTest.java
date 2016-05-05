package ru.javawebinar.webapp.storage.path;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.PathStorage;
import ru.javawebinar.webapp.storage.serializer.JsonStreamSerializer;

/**
 * GKislin
 * 01.11.2015.
 */
public class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
        super(new PathStorage(Config.getStoragePath(), new JsonStreamSerializer()));
    }
}
