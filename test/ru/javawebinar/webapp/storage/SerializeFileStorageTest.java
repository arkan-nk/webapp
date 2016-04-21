package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.Config;

/**
 * GKislin
 * 19.04.2016
 */
public class SerializeFileStorageTest extends AbstractStorageTest {
    public SerializeFileStorageTest() {
        super(new SerializeFileStorage(Config.STORAGE));
    }
}
