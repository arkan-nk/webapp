package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

/**
 * GKislin
 * 05.04.2016
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void shiftDeleted(String uuid, int idx) {
        array[idx] = array[size - 1];
    }

    @Override
    protected void insert(Resume r, int idx) {
        array[size] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
