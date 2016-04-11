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
        if(size>=ARRAY_LIMIT) throw new ArrayStoreException();
        if (size<1) {
            array[0] = r;
            size++;
            return;
        }
        int index = Arrays.binarySearch(array, 0, size, r, comparator);

        /*
        System.arraycopy(array, 0, array, index

        System.arraycopy(headArray, 0, array, 0, headArray.length);
        System.arraycopy(new Resume[]{r}, 0, array, headArray.length, 1);
        System.arraycopy(tailArray, 0, array, headArray.length + 2 , tailArray.length);*/
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
