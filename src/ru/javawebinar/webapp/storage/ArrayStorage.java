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
        if (size>=ARRAY_LIMIT-1) throw new ArrayIndexOutOfBoundsException("Storage are full");
        int index = getIndex(r.getUUid());
        if (index>=0) throw new IllegalArgumentException("Resume already exists");
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

    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] arr = Arrays.copyOf(array,size);
        Arrays.sort(arr, comparator);
        return Arrays.asList(arr);
    }
}