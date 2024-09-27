package Oncredit.BackendApp.Domain.Exception;

public class AnimalIncompatibleException extends RuntimeException {
    public AnimalIncompatibleException(String message) {
        super(message);
    }
}