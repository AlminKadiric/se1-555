package at.aau.serg.exercises.bookstore.service.exception;

public class InvoiceServiceException extends Exception {
    public InvoiceServiceException() {
        super();
    }

    public InvoiceServiceException(String message) {
        super(message);
    }
}
