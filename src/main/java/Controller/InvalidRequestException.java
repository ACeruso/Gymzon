package Controller;

import java.util.List;

public class InvalidRequestException extends Exception {
    private final List<String> errors;
    private final int errorCode;

    public InvalidRequestException(String message, List<String> errors, int errorCode) {
        super(message);
        this.errors = errors;
        this.errorCode = errorCode;
    }

    public List<String> getErrors() {
        return errors;
    }
}

