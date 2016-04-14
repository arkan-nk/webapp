package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractStorage implements Storage {
//    private final static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

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
        doSave(r);
    }

    @Override
    public void update(Resume r) {
        log.info("update " + r.getUuid());
        Objects.requireNonNull(r, "Resume must not be null");
        doUpdate(r);
    }

    @Override
    public void delete(String uuid) {
        log.info("delete " + uuid);
        requireNonNull(uuid, "UUID must not be null");
        doDelete(uuid);
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
        return doGet(uuid);
    }

    protected abstract void doClear();

    protected abstract int getSize();

    protected abstract Collection<Resume> getResumeCollection();

    protected abstract void doSave(Resume r) throws ResumeStorageException;

    protected abstract void doUpdate(Resume r) throws ResumeStorageException;

    protected abstract void doDelete(String uuid) throws ResumeStorageException;

    protected abstract Resume doGet(String uuid) throws ResumeStorageException;
}
