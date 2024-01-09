package at.aau.serg.exercises.bookstore.service;

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

import java.util.ArrayList;

public class InvoiceServiceImplUnitTest {
    InvoiceServiceImpl invoiceService;

    @BeforeEach
    public void setInstance() {
        ListInvoiceDao invoiceDao = new ListInvoiceDao();
        ListCustomerDao customerDao = new ListCustomerDao();
        ListBookDao bookDao = new ListBookDao();

        bookDao.insert(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
        bookDao.insert(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));

        Customer customer = new Customer(1L, "Almin", "Strasse 2");
        customerDao.insert(customer);

        ArrayList<Book> books = new ArrayList<>(2);
        books.add(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
        books.add(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));

        Invoice invoice = new Invoice(1L, customer, books, true);
        invoiceDao.insert(invoice);

        invoiceService = new InvoiceServiceImpl(invoiceDao, bookDao, customerDao);



    }
    @Test
    public void createInvoiceTest() throws InvoiceServiceException {
        ArrayList<Book> items = new ArrayList<Book>(2);
        items.add(new Book(1130101301L, "978-3-16-148410-0", "Lord Of the Rings 1", "J.R.R. Tolkien", 35.0));
       items.add(new Book(1130132423L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        Customer t = new Customer(1L, "Almin", "Strasse 2");
        try {
            Invoice c=invoiceService.createInvoice(items,t);
        } catch (InvoiceServiceException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(1,invoiceService.findAllInvoicesByCustomer(t).size());
    }
    @Test
    public void deleteInvoiceTest() throws InvoiceServiceException {
        Customer t = new Customer(1L, "Almin", "Strasse 2");
        ArrayList<Book> items = new ArrayList<Book>(2);
        items.add(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        items.add(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        Invoice i=new Invoice(1L,t,items,true);
        try {
            invoiceService.deleteInvoice(i);
        } catch (InvoiceServiceException e) {
            System.err.println(e.getMessage());
        }
        Assertions.assertEquals(0,invoiceService.findAllInvoicesByCustomer(t).size());
    }


}
