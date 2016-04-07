package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.ResumeFullNameComparator;
import ru.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
// TODO implement
public class ArrayStorageImpl implements Storage {
    private static final int ARRAY_LIMIT = 1000;
    private int count=0;

    private Resume[] array = new Resume[ARRAY_LIMIT];

    @Override
    public void clear() {
        count=0;
        array = new Resume[ARRAY_LIMIT];
    }

    @Override
    public void save(Resume r) {
        assert count<=ARRAY_LIMIT;
        Objects.requireNonNull(r);
        int indexNull = -1;
        int index=0;
        boolean toUpdate = false;
        boolean toInsert = false;
        for (Resume res :array) {
            toUpdate = (res!=null && res.getUuid().equals(r.getUuid()));
            if (toUpdate) break;
            toInsert = (res==null);
            if (toInsert && indexNull<0) indexNull=index;
            index++;
        }
        if (toUpdate) {array[index]=r; return;}
        if (toInsert) {count++; array[indexNull]=r;}
    }


    @Override
    public void update(Resume r) {
        Objects.requireNonNull(r);
        boolean toUpdate = false;
        int index = 0;
        for (Resume res :array) {
            toUpdate = (res!=null && res.getUuid().equals(r.getUuid()));
            if (toUpdate) break;
            index++;
        }
        if (toUpdate) array[index]=r;
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid);
        Resume result = null;
        UUID uuidReal = UUID.fromString(uuid);
        for (Resume res :array) {
            if (res.getUuid().equals(uuidReal)) {
                result = res; break;
            }
        }
        return result;
    }

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid);
        UUID uuidReal = UUID.fromString(uuid);
        int index = 0; boolean found = false;
        for (Resume res :array) {
            found = res.getUuid().equals(uuidReal);
            if (found) break;
            index++;
        }
        if (found) {array[index]= null; count--;}
    }

    @Override
    public Collection<Resume> getAllSorted() {
        if (array.length<1) return null;
        List<Resume> col = Arrays.asList(array);
        Collections.sort(col, new ResumeFullNameComparator());
        return col;
    }

    @Override
    public int size() {
        return count;
    }
}
