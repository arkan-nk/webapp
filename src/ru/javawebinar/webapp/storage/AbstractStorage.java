package ru.javawebinar.webapp.storage;

import java.util.logging.Logger;

/**
 * GKislin
 * 08.04.2016
 */
abstract public class AbstractStorage implements Storage {
//    private final static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public void clear() {
        log.info("clear");
        doClear();
    }

    protected abstract void doClear();
}
