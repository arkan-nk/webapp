package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
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
        for (Resume res : array) {
            toUpdate = (res!=null && res.getUuid().equals(r.getUuid()));
            if (toUpdate) break;
            toInsert = (res==null);
            if (toInsert && indexNull<0) indexNull=index;
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
            toUpdate = (res!=null && r.getUuid().equals(res.getUuid()));
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
            if (uuidReal.equals(res.getUUid())) {
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
            found = uuidReal.equals(res.getUuid());
            if (found) break;
            index++;
        }
        if (found) {array[index]= null; count--;}
    }

    @Override
    public Collection<Resume> getAllSorted() {
        if (count<1) return new ArrayList<>();
        List<Resume> col = Arrays.asList(array);
        ArrayList<Resume> arr = new ArrayList<Resume>();
        arr.addAll(col);
        Collection<Resume> nulls =  Collections.singleton(null);
        arr.removeAll(nulls);
        if (count>1) Collections.sort(arr, new ResumeUuidComparator());
        return arr;
    }

    @Override
    public int size() {
        return count;
    }
}