package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractStorage implements Storage {

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public void clear() {
        log.info("clear");
        doClear();
    }

    @Override
    public int size() {
        log.info("size");
        return getSize();
    }

    @Override
    public void save(Resume r) {
        log.info("save " + r.getUuid());
        Objects.requireNonNull(r, "Resume must not be null");
        int index = indexInStorage(r.getUuid());
        if (index>-1) throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " already exists");
        doSave(r, index);
    }

    @Override
    public void update(Resume r) {
        log.info("update " + r.getUuid());
        Objects.requireNonNull(r, "Resume must not be null");
        int index = indexInStorage(r.getUuid());
        if (index<0) throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " not found");
        doUpdate(r, index);
    }

    @Override
    public void delete(String uuid) {
        log.info("delete " + uuid);
        requireNonNull(uuid, "UUID must not be null");
        int index = indexInStorage(uuid);
        if (index<0) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        doDelete(uuid, index);
    }

    @Override
    public Collection<Resume> getAllSorted() {
        log.info("getAllSorted");
        return getResumeCollection();
    }

    @Override
    public Resume get(String uuid) {
        log.info("get " + uuid);
        requireNonNull(uuid, "UUID must not be null");
        int index = indexInStorage(uuid);
        if (index<0) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        return doGet(uuid, index);
    }


    protected abstract void doClear();

    protected abstract int getSize();

    protected abstract Collection<Resume> getResumeCollection();

    protected abstract void doSave(Resume r, int index);

    protected abstract void doUpdate(Resume r, int index);

    protected abstract void doDelete(String uuid, int index);

    protected abstract Resume doGet(String uuid, int index);

    protected abstract int indexInStorage(String uuid);
}
