package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Arrays;

/**
 * GKislin
 * 05.04.2016
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume r, int idx) {
//      http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insertIdx = -idx - 1;
        System.arraycopy(array, insertIdx, array, insertIdx + 1, size - insertIdx);
        array[insertIdx] = r;
    }

    @Override
    protected void shiftDeleted(int idx) {
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
    }

    protected Integer getContext(String uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null),
                (o1, o2) -> o1.getUuid().compareTo(o2.getUuid()));
    }
}
