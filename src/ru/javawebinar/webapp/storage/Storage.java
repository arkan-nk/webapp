package ru.javawebinar.webapp.storage;

/**
 * GKislin
 * 29.03.2016
 */
public interface Storage {
    default void defClear(){
        System.out.println();
    }

    void clear();
}
