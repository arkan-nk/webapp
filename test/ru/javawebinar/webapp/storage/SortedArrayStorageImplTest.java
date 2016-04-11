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
public class SortedArrayStorageImplTest {
    private LocalTime time0;
    private LocalTime time1;

    private static SortedArrayStorageImpl storage;

    public SortedArrayStorageImplTest() {
    }


    @BeforeClass
    public static void beforeClass() {
        storage = new SortedArrayStorageImpl();
        System.out.println("beforeClass");
    }

    @Before
    public void before() {
        time1 = null;
        ResumeTestData.init();
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
        time0 = LocalTime.now();
    }

    @After
    public void after() {
        time1 = LocalTime.now();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveExistent() throws Exception {
        storage.save(R1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void saveOver() {
        int fillNum = storage.size();
        for (int i = fillNum; i < 50000; i++) {
            Resume r = new Resume("test" + i, "test" + i);
            storage.save(r);
        }
        Resume rMax = new Resume("FFrfq", "trye");
        storage.save(rMax);
    }

    @Test
    public void update() throws Exception {
        R2.getContacts().clear();
        storage.update(R2);
        Resume r = storage.get(R2.getUuid());
        Assert.assertEquals(R2.getContacts().size(), r.getContacts().size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(R1, storage.get(R1.getUuid()));
        Assert.assertEquals(R2, storage.get(R2.getUuid()));
        Assert.assertEquals(R3, storage.get(R3.getUuid()));
    }

    @Test
    public void delete() throws Exception {
        storage.delete(R3.getUuid());
        Assert.assertEquals(storage.size(), 2);
    }

    @Test(expected = ResumeException.class)
    public void getDeleted() throws Exception {
        storage.delete(R3.getUuid());
        storage.get(R3.getUuid());
    }

    @Test
    public void getAllSorted() throws Exception {
        Collection coll = storage.getAllSorted();
        Assert.assertNotNull(coll);
        Assert.assertEquals(coll.size(), storage.size());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}
