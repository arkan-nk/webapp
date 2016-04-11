package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class SortedArrayStorageImpl extends AbstractArrayStorageImpl {



    @Override
    //TODO read please
    //http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
    public void save(Resume r) {
        Objects.requireNonNull(r);
        if(size>=ARRAY_LIMIT) throw new ArrayStoreException("Storage are completed");
        if (size<1) {
            array[0] = r;
            size++;
            return;
        }
        int index = Arrays.binarySearch(array, 0, size, r, comparator);
        if (index<0) index = -index-1;
        System.arraycopy(array, index, array, index + 1, size-index);
        array[index]=r;
        size++;
    }

    @Override
    protected int getIndex(UUID uuid) {
        return 0;
    }

    @Override
    public Resume get(String uuid) {
        UUID realUid = UUID.fromString(uuid);
        if (size<1) return null;
        if (size<2) {
            if (array[0].getUUid().equals(realUid)) return array[0];
            else return null;
        }
        int index = Arrays.binarySearch(array, new Resume(realUid, "", null), comparator);
        if (index < 0) return null;
        return array[index];
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] subarray = Arrays.copyOfRange(array, 0, size-1);
        return Arrays.asList(subarray);
    }
}
