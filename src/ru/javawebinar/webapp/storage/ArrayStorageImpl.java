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
        assert count<ARRAY_LIMIT;
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
        int index = findIndex(r.getUUid());
        if (index>-1) array[index]=r;
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid);
        Resume result = null;
        UUID uuidReal = UUID.fromString(uuid);
        int index = findIndex(uuidReal);
        if (index>-1) result = array[index];
        return result;
    }

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid);
        UUID uuidReal = UUID.fromString(uuid);
        int index = findIndex(uuidReal);
        if (index>-1) {array[index]= null; count--;}
    }

    @Override
    public Collection<Resume> getAllSorted() {
        if (count<1) return new ArrayList<>();
        List<Resume> col = Arrays.asList(array);
        ArrayList<Resume> arr = new ArrayList<Resume>();
        arr.addAll(col);
        Collection<Resume> nulls =  Collections.singleton(null);
        arr.remove(nulls);
        Collections.sort(arr, new ResumeUuidComparator());
        return arr;
    }

    @Override
    public int size() {
        return count;
    }

    private int findIndex(UUID uuidReal){
        int index = 0;
        boolean found = false;
        for (Resume res :array) {
            found = (uuidReal.equals(res.getUuid()));
            if (found) break;
            index++;
        }
        return found ? index : -1;
    }
}