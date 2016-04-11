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
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, " ", " "), comparator);
    }

    @Override
    public void save(Resume r) {
        Objects.requireNonNull(r);
        int index = getExistedIndex(r.getUuid());
        if (index<size) throw new ArrayStoreException();
        array[size++] = r;
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