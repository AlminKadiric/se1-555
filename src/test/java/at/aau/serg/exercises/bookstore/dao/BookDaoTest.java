package at.aau.serg.exercises.bookstore.dao;

import at.aau.serg.exercises.bookstore.dao.impl.ListBookDao;
import at.aau.serg.exercises.bookstore.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookDaoTest {

    private  ListBookDao lista = new ListBookDao();
    @Test
    public void insertBookTest(){
        lista.insert(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        lista.insert(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        Assertions.assertEquals(2,lista.findAll().size());
    }

    @Test
    public void updateBookTest(){
        lista.insert(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        lista.insert(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
       Book p=new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0);
        lista.update(p);
        Assertions.assertEquals(3,lista.findAll().size());
    }
    @Test
    public void deleteBookTest(){
        lista.insert(new Book(1130101301L,"978-3-16-148410-0","Lord Of the Rings 1","J.R.R. Tolkien",35.0));
        lista.insert(new Book(11301324231L,"978-3-16-148410-1","Lord Of the Rings 2","J.R.R. Tolkien",39.0));
        lista.delete(2L);
        Assertions.assertEquals(1,lista.findAll().size());
    }
}
