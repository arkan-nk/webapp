package ru.javawebinar.webapp;

/**
 * GKislin
 * 08.04.2016
 */
public class ResumeException extends RuntimeException {
    private final String uuid;

    public ResumeException(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

    public ResumeException(String uuid, String message, Throwable cause) {
        super(message, cause);
        this.uuid = uuid;
    }
}
