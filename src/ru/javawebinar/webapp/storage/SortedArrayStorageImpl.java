package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeException;
import ru.javawebinar.webapp.model.Resume;

import java.util.*;

import static java.util.Objects.requireNonNull;

/**
 * GKislin
 * 05.04.2016
 */
public class SortedArrayStorageImpl extends AbstractArrayStorageImpl {


    @Override
    //read http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
    public void save(Resume r) {
        Objects.requireNonNull(r);
        if (size < 1) {
            array[size++] = r;
            return;
        }
        int index = findIndexToSave(r);
        index = -index - 1;
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = r;
        size++;
    }

    @Override
    protected int getIndex(UUID uuid) {
        return Arrays.binarySearch(array, 0, size, new Resume(uuid, "", null), comparator);
    }

    @Override
    public Resume get(String uuid) {
        UUID realUid = UUID.fromString(uuid);
        if (size < 1) throw new ResumeException(uuid, "Resume with " + uuid + "not exist");
        if (size < 2) {
            if (array[0].getUUid().equals(realUid)) return array[0];
            else throw new ResumeException(uuid, "Resume with " + uuid + "not exist");

        }
        int index = getIndex(realUid);
        if (index < 0) throw new ResumeException(uuid, "Resume with " + uuid + "not exist");
        return array[index];
    }

    @Override
    public void delete(String uuid) {
        requireNonNull(uuid, "Uuid must be not null");
        UUID realUid = UUID.fromString(uuid);
        int indexTodel = getIndex(realUid);
        if (indexTodel < 0) throw new ResumeException(uuid, "Resume with " + uuid + "not exist");
        System.arraycopy(array, indexTodel + 1, array, indexTodel, size - indexTodel - 1);
        array[size--] = null;
    }
}
