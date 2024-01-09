package at.aau.serg.exercises.bookstore;

import at.aau.serg.exercises.bookstore.dao.BookDaoTest;
import at.aau.serg.exercises.bookstore.dao.CustomerDaoTest;
import at.aau.serg.exercises.bookstore.dao.InvoiceDaoTest;
import at.aau.serg.exercises.bookstore.service.InvoiceServiceImplIntegrationTest;
import at.aau.serg.exercises.bookstore.service.InvoiceServiceImplUnitTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({CustomerDaoTest.class, InvoiceDaoTest.class, BookDaoTest.class, InvoiceServiceImplIntegrationTest.class, InvoiceServiceImplUnitTest.class})
public class Exercise1AllTests {

}
