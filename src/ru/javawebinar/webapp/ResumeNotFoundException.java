package ru.javawebinar.webapp;

/**
 * GKislin
 * 08.04.2016
 */
public class ResumeNotFoundException extends ResumeStorageException {

    public ResumeNotFoundException(String uuid) {
        super(uuid, "Resume " + uuid + " not found");
    }
}
