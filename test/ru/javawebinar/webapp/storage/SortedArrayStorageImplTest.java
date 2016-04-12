package ru.javawebinar.webapp.storage;

import org.junit.*;
import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.ResumeTestData;
import ru.javawebinar.webapp.model.Resume;

import java.time.LocalTime;
import java.util.Collection;

import static ru.javawebinar.webapp.ResumeTestData.R1;
import static ru.javawebinar.webapp.ResumeTestData.R2;
import static ru.javawebinar.webapp.ResumeTestData.R3;

/**
 * Created by user on 11.04.2016.
 */
public class SortedArrayStorageImplTest extends AbstractStorageTest{
    public SortedArrayStorageImplTest() {
        storage = new SortedArrayStorageImpl();
    }
}
