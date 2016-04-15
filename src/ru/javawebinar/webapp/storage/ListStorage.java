package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Created by arkan on 14.04.2016.
 */
public class ListStorage extends AbstractStorage {
    private List<Resume> storageList;

    public ListStorage(List<Resume> list){
        storageList=list;
    }

    @Override
    protected void doClear() {
        storageList.clear();
    }

    @Override
    protected void doSave(Resume r, Condition condition){
        storageList.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Condition condition){
        storageList.set(((IndexCondition)condition).getValue(), r);
    }

    @Override
    protected Resume doGet(String uuid, Condition condition) {
        return storageList.get(((IndexCondition)condition).getValue());
    }

    @Override
    protected Condition conditionInStorage(String uuid) {
        IndexCondition ic = new IndexCondition();
        ic.setIndex(getIndex(uuid));
        return ic;
    }

    @Override
    protected void doDelete(String uuid, Condition condition) {
        storageList.remove(((IndexCondition)condition).getValue());
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

    private int getIndex(String uuid){
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

    private class UuidComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
}