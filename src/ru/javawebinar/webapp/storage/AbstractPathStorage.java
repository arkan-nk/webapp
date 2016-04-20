package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.ResumeStorageException;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 23.10.2015.
 */
public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    protected AbstractPathStorage(String Path) {
        directory = Paths.get(Path);
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(Path + " is not directory or is not writable");
        }
    }

    protected abstract void write(Resume r, OutputStream os) throws IOException;

    protected abstract Resume read(InputStream is) throws IOException;

    @Override
    protected Path getContext(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean exist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doClear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Path delete error");
        }
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Path " + path + " already exist");
        }
        doUpdate(r, path);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            write(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new ResumeStorageException(r.getUuid(), "Path write error", e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return read(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new ResumeStorageException(path.getFileName().toString(), "Path read error", e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new ResumeStorageException(path.getFileName().toString(), "Path delete error");
        }
    }

    @Override
    protected List<Resume> getAll() {
        try {
            return Files.list(directory).map(this::doGet).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Directory read error");
        }
    }

    @Override
    public int getSize() {
        try {
            return Files.list(directory).collect(Collectors.counting()).intValue();
        } catch (IOException e) {
            throw new ResumeStorageException(null, "Directory read error");
        }
    }
}
