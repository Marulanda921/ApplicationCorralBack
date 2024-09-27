package Oncredit.BackendApp.Domain.Exception;

public class CorralFullException extends RuntimeException {
    public CorralFullException(String message) {
        super(message);
    }
}
