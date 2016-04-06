package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * GKislin
 * 05.04.2016
 */
// TODO implement
public class ArrayStorageImpl implements Storage {
    private static final int ARRAY_LIMIT = 1000;

    private Resume[] array = new Resume[ARRAY_LIMIT];

    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
