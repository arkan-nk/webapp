package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class ArrayStorageImpl extends AbstractArrayStorageImpl{

    @Override
    protected int getIndex(UUID uuid) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Resume r) {
        Objects.requireNonNull(r);
        int index = getIndex(r.getUUid());
        if (index>=ARRAY_LIMIT) throw new ArrayStoreException("Storage are full");
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
        List<Resume> col = Arrays.asList(array);
        Collections.sort(col, comparator);
        return col;
    }
}