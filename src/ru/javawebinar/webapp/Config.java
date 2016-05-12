package ru.javawebinar.webapp;

import ru.javawebinar.webapp.storage.SqlStorage;
import ru.javawebinar.webapp.storage.Storage;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;

/**
 * GKislin
 * 24.10.2015.
 */
public class Config {
    private static Config INSTANCE;

    private Storage storage;
    private String storagePath;

    public static Config get() {
        INSTANCE = new Config();
        return INSTANCE;
    }
    public static Config get(String storageDir, String dbUrl, String dbUser, String dbPassword){
        INSTANCE = new Config(storageDir, dbUrl, dbUser, dbPassword);
        return INSTANCE;
    }


    public static Storage getStorage() {
        if (INSTANCE==null) Config.get();
        return INSTANCE.storage;
    }

    public static String getStoragePath() {
        if (INSTANCE==null) Config.get();
        return INSTANCE.storagePath;
    }

    private Config(String storageDir, String dbUrl, String dbUser, String dbPassword){
        storage = new SqlStorage(dbUrl, dbUser, dbPassword);
        storagePath = storageDir;
        INSTANCE=this;
        //logging();
    }
    private Config() {
        try (InputStream webAppIs = getClass().getClassLoader().getResourceAsStream("webapp.properties")) {
            Properties appProps = new Properties();
            appProps.load(webAppIs);
            storagePath = appProps.getProperty("storage.dir");
            storage = new SqlStorage(
                    appProps.getProperty("db.url"),
                    appProps.getProperty("db.user"),
                    appProps.getProperty("db.password"));

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        logging();
        INSTANCE=this;
    }

    private void logging(){
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
