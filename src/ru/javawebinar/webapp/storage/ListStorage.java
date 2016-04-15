package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Created by arkan on 14.04.2016.
 */
public class ListStorage extends AbstractStorage {
    private List<Resume> storageList;
    private Checker checker;

    public ListStorage(List<Resume> listForResume) {
        storageList = listForResume;
    }

    @Override
    protected void doClear() {
        storageList.clear();
    }

    @Override
    protected void doSave(Resume r) throws ResumeStorageException {
        storageList.add(r);
    }

    @Override
    protected void doUpdate(Resume r) throws ResumeStorageException {
        storageList.remove(r);
        storageList.add(r);
    }

    @Override
    protected Resume doGet(String uuid) throws ResumeStorageException {
        return storageList.get(checker.getCheckerIndex());
    }

    @Override
    protected boolean containsInStorage(String uuid) {
        checker = new Checker(uuid);
        return (checker.getCheckerIndex() > -1);
    }

    @Override
    protected void doDelete(String uuid) throws ResumeStorageException {
        storageList.remove(checker.getCheckerIndex());
    }

    @Override
    protected Collection<Resume> getResumeCollection() {
        Resume[] resumeArray = storageList.toArray(new Resume[storageList.size()]);
        Arrays.sort(resumeArray, new UuidComparator());
        return Arrays.asList(resumeArray);
    }

    @Override
    protected int getSize() {
        return storageList.size();
    }

    private int indexInStorage(String uuid) throws ResumeStorageException {
        int index = 0;
        for (Resume res : storageList) {
            if (uuid.equals(res.getUuid())) return index;
            index++;
        }
        return -1;
        /*
        Collections.sort(storageList, new UuidComparator());
        int index = Collections.binarySearch(storageList, new Resume(uuid, "", null), new UuidComparator());
        if (index < 0) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        return index;
        */
    }

    private class Checker {
        public Checker(String u) {
            uuid = u;
            index = indexInStorage(u);
        }

        public int getCheckerIndex() {
            return index;
        }

        private String uuid;
        private int index;
    }

    private class UuidComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
}
