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
    private static final Config INSTANCE = new Config();

    private Storage storage;
    private String storagePath;

    public static Config get() {
        return INSTANCE;
    }

    public static Storage getStorage() {
        return get().storage;
    }

    public static String getStoragePath() {
        return get().storagePath;
    }

    public Config() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("logging.properties");
             InputStream webAppIs = getClass().getClassLoader().getResourceAsStream("webapp.properties")
        ) {
            LogManager.getLogManager().readConfiguration(is);

            Properties appProps = new Properties();
            appProps.load(webAppIs);

            storagePath = appProps.getProperty("storage.dir");

//          storage = new FileStorage(storagePath, new XmlStreamSerializer());

            storage = new SqlStorage(
                    appProps.getProperty("db.url"),
                    appProps.getProperty("db.user"),
                    appProps.getProperty("db.password"));

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
