package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(UUID uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUUid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Resume r) {
        Objects.requireNonNull(r);
        if (size < 1) {
            array[size++] = r;
            return;
        }
        findIndexToSave(r);
        array[size++] = r;
    }

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid);
        array[getExistedIndex(uuid)] = array[--size];
        array[size] = null;
    }


    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid);
        int index = getExistedIndex(uuid);
        return (index>-1) ? array[index] : null;
    }
}