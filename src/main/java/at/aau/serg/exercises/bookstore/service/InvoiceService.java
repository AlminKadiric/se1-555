package at.aau.serg.exercises.bookstore.service;

import java.util.List;

import at.aau.serg.exercises.bookstore.entity.Book;
import at.aau.serg.exercises.bookstore.entity.Customer;
import at.aau.serg.exercises.bookstore.entity.Invoice;
import at.aau.serg.exercises.bookstore.service.exception.InvoiceServiceException;

public interface InvoiceService {
    Invoice createInvoice(List<Book> items, Customer customer)
            throws InvoiceServiceException;

    void deleteInvoice(Invoice invoice) throws InvoiceServiceException;

    List<Invoice> findAllInvoicesByCustomer(Customer customer)
            throws InvoiceServiceException;
}