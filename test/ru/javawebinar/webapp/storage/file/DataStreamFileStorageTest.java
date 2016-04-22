package ru.javawebinar.webapp.storage.file;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.FileStorage;
import ru.javawebinar.webapp.storage.serializer.DataStreamSerializer;

/**
 * GKislin
 * 09.10.2015.
 */
public class DataStreamFileStorageTest extends AbstractStorageTest {
    public DataStreamFileStorageTest() {
        super(new FileStorage(Config.STORAGE_PATH, new DataStreamSerializer()));
    }
}
