package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.Comparator;
import java.util.UUID;

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

    protected abstract int getIndex(UUID uuid);

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
//        Arrays.fill(array, null); // let gc do h work
    }

    @Override
    public void update(Resume r) {
        requireNonNull(r);
        array[getExistedIndex(r.getUuid())] = r;
    }

    @Override
    public void delete(String uuid){
        requireNonNull(uuid, "Uuid must be not null");
        int indexTodel = getExistedIndex(uuid);
        System.arraycopy(array, indexTodel+1, array, indexTodel, size-1);
        array[size--]=null;
    }

    @Override
    public int size(){
        return size;
    }
}
