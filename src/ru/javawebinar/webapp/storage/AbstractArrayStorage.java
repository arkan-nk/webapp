package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractArrayStorage extends AbstractStorage {
    protected static final int ARRAY_LIMIT = 50000;

    protected Resume[] array = new Resume[ARRAY_LIMIT];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    protected abstract void shiftDeleted(String uuid, int idx);

    protected abstract void insert(Resume r, int idx);


    @Override
    public void doClear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    protected void doSave(Resume r, int index) {
        if (size == ARRAY_LIMIT) {
            throw new ResumeStorageException(r.getUuid(), "Array size limit(" + ARRAY_LIMIT + ") exceeded");
        }
        insert(r, index);
        size++;
    }

    @Override
    protected void doUpdate(Resume r, int index) {
        array[index] = r;
    }

    @Override
    protected Resume doGet(String uuid, int index) {
        return array[index];
    }

    @Override
    protected void doDelete(String uuid, int index) {
        shiftDeleted(uuid, index);
        array[size--] = null;
    }

    @Override
    protected Collection<Resume> getResumeCollection() {
        Resume[] copy = Arrays.copyOf(array, size);
        Arrays.sort(copy);
        return Arrays.asList(copy);
    }

    @Override
    protected int indexInStorage(String uuid) {
        return getIndex(uuid);
    }

    @Override
    protected int getSize() {
        return size;
    }
}
