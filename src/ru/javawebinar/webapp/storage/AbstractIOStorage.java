package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.storage.serializer.StreamSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * GKislin
 * 22.04.2016
 */
public abstract class AbstractIOStorage<C> extends AbstractStorage<C> {
    private final StreamSerializer streamSerializer;

    protected AbstractIOStorage(StreamSerializer streamSerializer) {
        this.streamSerializer = streamSerializer;
    }

    protected void write(Resume r, OutputStream os) throws IOException {
        streamSerializer.write(r, os);
    }

    protected Resume read(InputStream is) throws IOException {
        return streamSerializer.read(is);
    }
}
