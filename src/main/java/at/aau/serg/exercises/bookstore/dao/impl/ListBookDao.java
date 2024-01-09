package at.aau.serg.exercises.bookstore.dao.impl;

import at.aau.serg.exercises.bookstore.dao.BookDao;
import at.aau.serg.exercises.bookstore.entity.Book;

public class ListBookDao extends ListDao<Book> implements BookDao {
    public ListBookDao() {
        this.currentId = 1L;
    }
}
