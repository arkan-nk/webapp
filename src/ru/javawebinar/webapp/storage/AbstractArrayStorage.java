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

    private Checker checker;

    @Override
    public void doClear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    protected void doSave(Resume r) {
        if (size == ARRAY_LIMIT) {
            throw new ResumeStorageException(r.getUuid(), "Array size limit(" + ARRAY_LIMIT + ") exceeded");
        }
        insert(r, checker.getCheckerIndex());
        size++;
    }

    @Override
    protected void doUpdate(Resume r) {
        array[checker.getCheckerIndex()] = r;
    }

    @Override
    protected Resume doGet(String uuid) {
        return array[checker.getCheckerIndex()];
    }

    @Override
    protected void doDelete(String uuid) {
        shiftDeleted(uuid, checker.getCheckerIndex());
        array[size--] = null;
    }

    @Override
    protected Collection<Resume> getResumeCollection() {
        Resume[] copy = Arrays.copyOf(array, size);
        Arrays.sort(copy);
        return Arrays.asList(copy);
    }

    @Override
    protected boolean containsInStorage(String uuid){
        checker = new Checker(uuid);
        return (checker.getCheckerIndex()>-1);
    }

    @Override
    protected int getSize() {
        return size;
    }

    private class Checker {
        private String uuid;
        private int index;
        public Checker(String u){
            uuid = u;
            index = getIndex(uuid);
        }
        public int getCheckerIndex(){
            return index;
        }
    }
}
