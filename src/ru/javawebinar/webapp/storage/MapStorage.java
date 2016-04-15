package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 12.04.2016
 */
public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storageMap;

    public MapStorage(Map<String, Resume> mapForResume) {
        storageMap = mapForResume;
    }

    @Override
    protected void doClear() {
        storageMap.clear();
    }

    @Override
    protected int getSize() {
        return storageMap.size();
    }

    @Override
    protected Collection<Resume> getResumeCollection() {
        Resume[] mapArray = storageMap.values().toArray(new Resume[storageMap.size()]);
        Arrays.sort(mapArray, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
        return Arrays.asList(mapArray);
    }

    @Override
    protected void doSave(Resume r) {
        //if (storageMap.containsKey(r.getUuid()))
        //    throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " already exists");
        storageMap.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r) {
        //if (!storageMap.containsKey(r.getUuid()))
        //   throw new ResumeStorageException(r.getUuid(), "Resume " + r.getUuid() + " not found");
        storageMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(String uuid) {
        //if (!storageMap.containsKey(uuid)) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        storageMap.remove(uuid);
    }

    @Override
    protected Resume doGet(String uuid) {
        //if (!storageMap.containsKey(uuid)) throw new ResumeStorageException(uuid, "Resume " + uuid + " not found");
        return storageMap.get(uuid);
    }

    @Override
    protected boolean containsInStorage(String uuid) {
        return storageMap.containsKey(uuid);
    }
}
