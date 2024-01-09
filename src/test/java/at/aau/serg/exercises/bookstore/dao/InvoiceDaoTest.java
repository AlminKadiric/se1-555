package at.aau.serg.exercises.bookstore.dao;

import at.aau.serg.exercises.bookstore.dao.impl.ListInvoiceDao;
import at.aau.serg.exercises.bookstore.entity.Book;
import at.aau.serg.exercises.bookstore.entity.Customer;
import at.aau.serg.exercises.bookstore.entity.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InvoiceDaoTest {
    private ListInvoiceDao lista=new ListInvoiceDao();
    @Test
    public void insertInvoiceTest() {
        Customer t = new Customer(1L, "Almin", "Strasse 2");
        ArrayList<Book> items = new ArrayList<Book>(2);
//        (Long id, String isbn13, String title, String author, double price)
        items.add(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        items.add(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        items.add(new Book(121330101301L,"978-3-16-148410-2","Harry Potter 1","J. K. Rowling",43.0));
        Invoice i=new Invoice(1L,t,items,true);
        lista.insert(i);
        Assertions.assertEquals(1, lista.findAll().size());
    }
    @Test
    public void updateInvoiceTest(){
        Customer t = new Customer(1L, "Almin", "Strasse 2");
        ArrayList<Book> items = new ArrayList<Book>(2);
//        (Long id, String isbn13, String title, String author, double price)
        items.add(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        items.add(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        items.add(new Book(121330101301L,"978-3-16-148410-2","Harry Potter 1","J. K. Rowling",43.0));
        Invoice i=new Invoice(1L,t,items,true);
        lista.insert(i);
        Invoice i2=new Invoice(1L,t,items,false);
        lista.update(i2);
        Assertions.assertEquals(1,lista.findAll().size());
    }
    @Test
    public void deleteInvoiceTest(){
        Customer t = new Customer(1L, "Almin", "Strasse 2");
        ArrayList<Book> items = new ArrayList<Book>(2);
//        (Long id, String isbn13, String title, String author, double price)
        items.add(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        items.add(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        items.add(new Book(121330101301L,"978-3-16-148410-2","Harry Potter 1","J. K. Rowling",43.0));
        Invoice i=new Invoice(1L,t,items,true);
        lista.insert(i);
        lista.delete(1L);
        Assertions.assertEquals(0,lista.findAll().size());
    }
}
