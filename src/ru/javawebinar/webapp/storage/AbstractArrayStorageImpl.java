package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.*;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractArrayStorageImpl extends AbstractStorageImpl {
    protected static final int ARRAY_LIMIT = 50000;

    protected Resume[] array = new Resume[ARRAY_LIMIT];
    protected int size = 0;
    protected Comparator<Resume> comparator=new ResumeUuidComparator();

    protected int getExistedIndex(String uuid) {
        int idx = getIndex(UUID.fromString(uuid));
        if (idx < 0) {
            throw new ResumeException(uuid, "Resume with " + uuid + "not exist");
        }
        return idx;
    }

    protected int findIndexToSave(Resume r){
        if (size>=ARRAY_LIMIT-1) throw new ArrayIndexOutOfBoundsException("Storage are full");
        int index = getIndex(r.getUUid());
        if (index>=0) throw new IllegalArgumentException("Resume already exists");
        return index;
    }

    protected abstract int getIndex(UUID uuid);

    @Override
    public void clear() {
        for (int index=0; index<size; index++) {
            array[index]=null;
        }
        size=0;
    }

    @Override
    public void update(Resume r) {
        requireNonNull(r);
        array[getExistedIndex(r.getUuid())] = r;
    }


    @Override
    public int size(){
        return size;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] arr = Arrays.copyOfRange(array,0, size);
        Arrays.sort(arr, comparator);
        return Arrays.asList(arr);
    }
}
