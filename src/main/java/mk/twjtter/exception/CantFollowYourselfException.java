package mk.twjtter.exception;

public class CantFollowYourselfException extends RuntimeException {
    public CantFollowYourselfException(String message) {
        super(message);
    }
}
