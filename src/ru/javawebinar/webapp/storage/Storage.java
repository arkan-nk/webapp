package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * GKislin
 * 29.03.2016
 */
public interface Storage {
    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}
