package Oncredit.BackendApp.Domain.Exception;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}