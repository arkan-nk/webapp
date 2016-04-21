package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 23.10.2015.
 */
public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected AbstractFileStorage(String path) {
        directory = new File(path);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(path + " is not directory");
        }
    }

    protected abstract void write(Resume r, OutputStream os) throws IOException;

    protected abstract Resume read(InputStream is) throws IOException;

    @Override
    protected File getContext(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean exist(File file) {
        return file.isFile();
    }

    @Override
    protected void doClear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            if (!file.createNewFile()) {
                throw new ResumeStorageException(r.getUuid(), "File " + file.getAbsolutePath() + " already exist");
            }
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Couldn't create file " + file.getAbsolutePath(), e);
        }
        doUpdate(r, file);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            write(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "File write error", e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return read(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new ResumeStorageException(file.getName(), "File read error", e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new ResumeStorageException(file.getName(), "File delete error");
        }
    }

    @Override
    protected List<Resume> getAll() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new ResumeStorageException(null, "Directory read error");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public int getSize() {
        String[] list = directory.list();
        if (list == null) {
            throw new ResumeStorageException(null, "Directory read error");
        }
        return list.length;
    }
}
