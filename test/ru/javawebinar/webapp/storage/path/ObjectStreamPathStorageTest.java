package ru.javawebinar.webapp.storage.path;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.PathStorage;
import ru.javawebinar.webapp.storage.serializer.ObjectStreamSerializer;

/**
 * GKislin
 * 19.04.2016
 */
public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(Config.STORAGE_PATH, new ObjectStreamSerializer()));
    }
}
