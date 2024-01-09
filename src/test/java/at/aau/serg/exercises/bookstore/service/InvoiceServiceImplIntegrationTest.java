package at.aau.serg.exercises.bookstore.service;

import at.aau.serg.exercises.bookstore.dao.BookDao;
import at.aau.serg.exercises.bookstore.dao.CustomerDao;
import at.aau.serg.exercises.bookstore.dao.InvoiceDao;
import at.aau.serg.exercises.bookstore.dao.impl.ListBookDao;
import at.aau.serg.exercises.bookstore.dao.impl.ListCustomerDao;
import at.aau.serg.exercises.bookstore.dao.impl.ListInvoiceDao;
import at.aau.serg.exercises.bookstore.entity.Book;
import at.aau.serg.exercises.bookstore.entity.Customer;
import at.aau.serg.exercises.bookstore.entity.Invoice;
import at.aau.serg.exercises.bookstore.service.exception.InvoiceServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import  org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class InvoiceServiceImplIntegrationTest {
    @Mock
    private InvoiceDao invoiceDao;

    @Mock
    private BookDao bookDao;

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void shouldCreateInvoiceSuccessfully() throws InvoiceServiceException {

        List<Book> books = Arrays.asList(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
        Customer customer = new Customer(1L, "Almin", "Strasse 2");
        Invoice expectedInvoice = new Invoice(1L, customer, books, true);

        when(customerDao.findOne(customer.getId())).thenReturn(customer);
        for (Book book : books) {
            when(bookDao.findOne(book.getId())).thenReturn(book);
        }
        when(invoiceDao.insert(Mockito.any(Invoice.class))).thenReturn(expectedInvoice);


        Invoice result = invoiceService.createInvoice(books, customer);


        Assertions.assertEquals(expectedInvoice, result);
        Mockito.verify(invoiceDao).insert(Mockito.any(Invoice.class));
    }

    @Test
    void shouldDeleteInvoiceSuccessfully() throws InvoiceServiceException {
        List<Book> books = Arrays.asList(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
        Customer customer = new Customer(1L, "Almin", "Strasse 2");
        Invoice invoice = new Invoice(1L, customer, books, true);
        when(invoiceDao.findOne(invoice.getId())).thenReturn(invoice);

        invoiceService.deleteInvoice(invoice);

        Mockito.verify(invoiceDao).delete(invoice.getId());
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentInvoice() {
        List<Book> books = Arrays.asList(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
        Customer customer = new Customer(1L, "Almin", "Strasse 2");
        Invoice invoice = new Invoice(1L, customer, books, true);
        when(invoiceDao.findOne(invoice.getId())).thenReturn(null);


        Assertions.assertThrows(InvoiceServiceException.class, () -> invoiceService.deleteInvoice(invoice));
    }

    @Test
    void shouldFindAllInvoicesByCustomer() throws InvoiceServiceException {
        List<Book> books = Arrays.asList(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));

        Customer customer = new Customer(1L, "Almin", "Strasse 2");


        List<Invoice> allInvoices = Arrays.asList(new Invoice(1L, customer, books, true));
        when(customerDao.findOne(customer.getId())).thenReturn(customer);
        when(invoiceDao.findAll()).thenReturn(allInvoices);


        List<Invoice> result = invoiceService.findAllInvoicesByCustomer(customer);


        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());

    }

    @Test
    void shouldThrowExceptionForNonExistentCustomer() {
        Customer customer = new Customer(2L, "Alex", "Strasse 3");

        when(customerDao.findOne(customer.getId())).thenReturn(null);

        Assertions.assertThrows(InvoiceServiceException.class, () -> {
            invoiceService.findAllInvoicesByCustomer(customer);
        });


    }
}
