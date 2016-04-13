package ru.javawebinar.webapp;

/**
 * GKislin
 * 08.04.2016
 */
public class ResumeStorageException extends ResumeException {

    public ResumeStorageException(String uuid, String message) {
        super(uuid, message);
    }

    public ResumeStorageException(String uuid, String message, Throwable cause) {
        super(uuid, message, cause);
    }
}
