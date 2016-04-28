package ru.javawebinar.webapp;

import ru.javawebinar.webapp.storage.FileStorage;
import ru.javawebinar.webapp.storage.Storage;
import ru.javawebinar.webapp.storage.serializer.XmlStreamSerializer;

/**
 * GKislin
 * 24.10.2015.
 */
public class Config {
    public static final String STORAGE_PATH = "D:\\javawebinar\\course_webapp\\webapp\\storage";

    public static final Storage STORAGE = new FileStorage(STORAGE_PATH, new XmlStreamSerializer());
}
