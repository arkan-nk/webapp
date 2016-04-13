package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Created by arkan on 14.04.2016.
 */
public class ListStorage extends AbstractStorage {
    private List<Resume> storageList;

    public ListStorage(List<Resume> listForResume) {
        storageList = listForResume;
    }

    @Override
    protected void doClear() {
        storageList.clear();
    }

    @Override
    protected void doSave(Resume r) throws ResumeStorageException {
        if (storageList.contains(r))
            throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " already exists");
        storageList.add(r);
    }

    @Override
    protected void doUpdate(Resume r) throws ResumeStorageException {
        if (!storageList.contains(r))
            throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " not found");
        storageList.remove(r);
        storageList.add(r);
    }

    @Override
    protected Resume doGet(String uuid) throws ResumeStorageException {
        int index = indexInStorage(uuid);
        return storageList.get(index);
    }

    @Override
    protected void doDelete(String uuid) throws ResumeStorageException {
        int index = indexInStorage(uuid);
        storageList.remove(index);
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
        Collections.sort(storageList, new UuidComparator());
        int index = Collections.binarySearch(storageList, new Resume(uuid, "", null), new UuidComparator());
        if (index < 0) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        return index;
    }

    private class UuidComparator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
}
