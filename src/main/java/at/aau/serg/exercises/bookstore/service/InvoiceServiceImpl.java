package at.aau.serg.exercises.bookstore.service;

import at.aau.serg.exercises.bookstore.dao.BookDao;
import at.aau.serg.exercises.bookstore.dao.CustomerDao;
import at.aau.serg.exercises.bookstore.dao.InvoiceDao;
import at.aau.serg.exercises.bookstore.entity.Book;
import at.aau.serg.exercises.bookstore.entity.Customer;
import at.aau.serg.exercises.bookstore.entity.Invoice;
import at.aau.serg.exercises.bookstore.service.exception.InvoiceServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDao invoiceDao;
    private final BookDao bookDao;
    private final CustomerDao customerDao;

    public InvoiceServiceImpl(InvoiceDao invoiceDao, BookDao bookDao, CustomerDao customerDao) {
        this.invoiceDao = invoiceDao;
        this.bookDao = bookDao;
        this.customerDao = customerDao;
    }



    public Invoice createInvoice(List<Book> items, Customer customer)
            throws InvoiceServiceException {
        checkCustomer(customer);
        checkBooks(items);

        final Invoice newInvoice = new Invoice();
        newInvoice.setCustomer(customer);
        newInvoice.setBooks(items);
        newInvoice.setPaid(false);

        return invoiceDao.insert(newInvoice);
    }

    public void deleteInvoice(Invoice invoice)
            throws InvoiceServiceException {
        checkInvoice(invoice);
        invoiceDao.delete(invoice.getId());
    }

    public List<Invoice> findAllInvoicesByCustomer(Customer customer)
            throws InvoiceServiceException {
        checkCustomer(customer);

        final List<Invoice> retVal = new ArrayList<>();

        final List<Invoice> findAll = invoiceDao.findAll();
        for (Invoice invoice : findAll) {
            if (Objects.equals(invoice.getCustomer().getId(), customer.getId())) {
                retVal.add(invoice);
            }
        }

        return retVal;
    }

    public void checkInvoice(Invoice invoice) throws InvoiceServiceException {
        if (invoiceDao.findOne(invoice.getId()) == null) {
            throw new InvoiceServiceException("Invoice does not exist (" + invoice.getId() + ").");
        }
    }

    public void checkBooks(List<Book> books)
            throws InvoiceServiceException {
        for (Book book : books) {
            checkProduct(book);
        }
    }

    public void checkProduct(Book b) throws InvoiceServiceException {
        Book found = bookDao.findOne(b.getId());
        if (found == null) {
            throw new InvoiceServiceException(String.format("Book does not exist (%d).", b.getId()));
        }
        if (!found.validateIsbn13()) {
            throw new InvoiceServiceException(String.format("Book contains an invalid ISBN (%s).", b.getIsbn13()));
        }
    }

    public void checkCustomer(Customer customer)
            throws InvoiceServiceException {
        if (customerDao.findOne(customer.getId()) == null) {
            throw new InvoiceServiceException("Customer does not exist.");
        }
    }
}
