package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;
import ru.javawebinar.webapp.model.ResumeUuidComparator;

import java.util.*;

/**
 * GKislin
 * 05.04.2016
 */
public class SortedArrayStorageImpl implements Storage {
    private Comparator<Resume> comparator=new ResumeUuidComparator();
    private static final int ARRAY_LIMIT = 1000;
    private int count = 0;
    private Resume[] array = new Resume[ARRAY_LIMIT];

    @Override
    public void clear() {
        count = 0;
        array = new Resume[ARRAY_LIMIT];
    }


    @Override
    public void save(Resume r) {
        Objects.requireNonNull(r);
        assert count < ARRAY_LIMIT;
        if (count<1) {
            array[0] = r;
            count++;
            return;
        }
        if (count<2) {
            int comResult = comparator.compare(array[0], r);
            if (comResult==0) array[0]=r;
            if (comResult<0) array[1]=r;
            if (comResult>0) {
                array[1]=array[0];
                array[0]=r;
            }
            if(comResult!=0) count++;
            return;
        }
        int start = 0;
        int comResult = -1;
        for (Resume resumeArray : array){
            comResult = comparator.compare(resumeArray, r);
            if (comResult>=0) break;
            start++;
        }
        if (comResult==0) {
            array[start]=r; return;
        }
        if (comResult<0) {
            array[count++]=r; return;
        }
        Resume[] headArray = Arrays.copyOfRange(array, 0, start-1);
        Resume[] tailArray = Arrays.copyOfRange(array, start, count - 1);
        array = new Resume[ARRAY_LIMIT];
        System.arraycopy(headArray, 0, array, 0, headArray.length);
        System.arraycopy(new Resume[]{r}, 0, array, headArray.length, 1);
        System.arraycopy(tailArray, 0, array, headArray.length + 2 , tailArray.length);
        count++;
    }

    @Override
    public void update(Resume r) {
        Objects.requireNonNull(r);
        //if (count>1) Arrays.sort(array, comparator);
        int start = Arrays.binarySearch(array, r, comparator);
        if (start>0) array[start] = r; else array[count++]=r;
    }

    @Override
    public Resume get(String uuid) {
        UUID realUid = UUID.fromString(uuid);
        if (count<1) return null;
        if (count<2) {
            if (array[0].getUUid().equals(realUid)) return array[0]; else return null;
        }
        //Arrays.sort(array, comparator);
        int index = Arrays.binarySearch(array, new Resume(realUid, "no", null), comparator);
        if (index < 0) return null;
        return array[index];
    }

    @Override
    public void delete(String uuid) {
        UUID realUid = UUID.fromString(uuid);
        if (count<1) return;
        if (count<2) {
            if (array[0].getUUid().equals(realUid)) {
                array = new Resume[ARRAY_LIMIT];
                count = 0;
            }
            return;
        }
        int index = Arrays.binarySearch(array, new Resume(realUid, "no", null), comparator);
        if (index<0) return;
        Resume[] tailArray = Arrays.copyOfRange(array, index+1, count - 1);
        if (index==0) {
            array = new Resume[ARRAY_LIMIT];
            System.arraycopy(tailArray, 0, array, 0, tailArray.length);
        }else {
            Resume[] headArray = Arrays.copyOfRange(array, 0, index - 1);
            array = new Resume[ARRAY_LIMIT];
            int length = headArray.length;
            System.arraycopy(headArray, 0, array, 0, length);
            System.arraycopy(tailArray, 0, array, length, tailArray.length);
        }
        count--;
    }


    @Override
    public Collection<Resume> getAllSorted() {
        Resume[] subarray = Arrays.copyOfRange(array, 0, count-1);
        List<Resume> resumeList = Arrays.asList(subarray);
        return resumeList;
    }

    @Override
    public int size() {
        return count;
    }
}
