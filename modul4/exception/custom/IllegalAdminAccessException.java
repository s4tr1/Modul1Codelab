package modul4.tugas.exception.custom;

public class IllegalAdminAccessException extends Exception {
    public IllegalAdminAccessException() {
        super();
    }

    public IllegalAdminAccessException(String message) {
        super(message);
    }

    public IllegalAdminAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAdminAccessException(Throwable cause) {
        super(cause);
    }
}

