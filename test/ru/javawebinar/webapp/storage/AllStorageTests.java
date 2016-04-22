package ru.javawebinar.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.javawebinar.webapp.storage.file.DataStreamFileStorageTest;
import ru.javawebinar.webapp.storage.file.XmlFileStorageTest;
import ru.javawebinar.webapp.storage.path.JsonPathStorageTest;
import ru.javawebinar.webapp.storage.path.ObjectStreamPathStorageTest;
import ru.javawebinar.webapp.storage.path.XmlPathStorageTest;

/**
 * GKislin
 * 09.01.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapResumeStorageTest.class,
                MapUuidStorageTest.class,
                DataStreamFileStorageTest.class,
                ObjectStreamPathStorageTest.class,
                JsonPathStorageTest.class,
                XmlFileStorageTest.class,
                XmlPathStorageTest.class
        })
public class AllStorageTests {
}
