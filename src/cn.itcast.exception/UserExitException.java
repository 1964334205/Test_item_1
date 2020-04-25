package cn.itcast.exception;

public class UserExitException extends Exception  {

    public UserExitException() {
        super();
    }

    public UserExitException(String message) {
        super(message);
    }

    public UserExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExitException(Throwable cause) {
        super(cause);
    }

    protected UserExitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
