package ru.javawebinar.webapp.storage.serializer;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;

/**
 * GKislin
 * 19.04.2016
 */
public class ObjectStreamSerializer implements StreamSerializer {

    @Override
    public void write(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new ResumeStorageException(null, "Error read resume", e);
        }
    }
}
