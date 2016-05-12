package ru.javawebinar.webapp.util;

import org.h2.api.ErrorCode;
import org.h2.jdbc.JdbcSQLException;
import ru.javawebinar.webapp.ResumeStorageException;

import java.sql.SQLException;

/**
 * GKislin
 * http://javawebinar.ru/basejava/
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static ResumeStorageException convertException(SQLException e) {
        if (e instanceof JdbcSQLException) {
//          http://h2database.com/javadoc/org/h2/api/ErrorCode.html?highlight=error&search=error
            if (e.getSQLState().equals(ErrorCode.DUPLICATE_KEY_1)) {
                return new ResumeStorageException(null, "Resume alredy exists", e);
            }
        }
        return new ResumeStorageException(e);
    }
}
