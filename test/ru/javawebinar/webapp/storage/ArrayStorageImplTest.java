package ru.javawebinar.webapp.storage;

//import org.junit.*;
import ru.javawebinar.webapp.*;

//import static ru.javawebinar.webapp.ResumeTestData.*;

/**
 * GKislin
 * 08.04.2016
 */
public class ArrayStorageImplTest {
    static Storage storage;

/*
    static {
       storage = new ArrayStorageImpl();
    }
*/

    public ArrayStorageImplTest() {
        storage = new ArrayStorageImpl();
    }

    @BeforeClass
    public static void beforeClass() {
        storage = new ArrayStorageImpl();
        System.out.println("beforeClass");
    }

    @Before
    public void before() {
        ResumeTestData.init();
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(R1, storage.get(UUID1));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getAllSorted() throws Exception {

    }

    @Test
    public void size() throws Exception {

    }

}