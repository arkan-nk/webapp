package ru.javawebinar.webapp.storage.path;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.PathStorage;
import ru.javawebinar.webapp.storage.serializer.DataStreamSerializer;

/**
 * GKislin
 * 09.10.2015.
 */
public class DataStreamPathStorageTest extends AbstractStorageTest {
    public DataStreamPathStorageTest() {
        super(new PathStorage(Config.STORAGE, new DataStreamSerializer()));
    }
}
