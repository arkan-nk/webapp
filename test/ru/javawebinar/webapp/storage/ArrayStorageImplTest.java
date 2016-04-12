package ru.javawebinar.webapp.storage;

import org.junit.*;
import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.ResumeTestData;
import ru.javawebinar.webapp.model.Resume;

import java.time.LocalTime;
import java.util.Collection;

import static ru.javawebinar.webapp.ResumeTestData.*;

/**
 * GKislin
 * 08.04.2016
 */
public class ArrayStorageImplTest extends AbstractStorageTest{


    public ArrayStorageImplTest() {
    }

    @BeforeClass
    public static void beforeClass() {
        storage = new ArrayStorageImpl();
        System.out.println("beforeClass");
    }


}