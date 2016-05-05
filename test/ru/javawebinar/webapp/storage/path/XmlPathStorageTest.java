package ru.javawebinar.webapp.storage.path;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.storage.AbstractStorageTest;
import ru.javawebinar.webapp.storage.PathStorage;
import ru.javawebinar.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(Config.getStoragePath(), new XmlStreamSerializer()));
    }
}