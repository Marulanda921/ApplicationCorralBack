package Oncredit.BackendApp.Domain.Exception;

public class CorralNotFoundException extends RuntimeException {
    public CorralNotFoundException(String message) {
        super(message);
    }
}