package ru.javawebinar.webapp.storage.file;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.FileStorage;
import ru.javawebinar.webapp.storage.serializer.XmlStreamSerializer;

public class XmlFileStorageTest extends AbstractStorageTest {
    public XmlFileStorageTest() {
        super(new FileStorage(Config.STORAGE_PATH, new XmlStreamSerializer()));
    }
}