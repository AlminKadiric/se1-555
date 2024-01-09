package at.aau.serg.exercises.bookstore.service;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({InvoiceServiceImplIntegrationTest.class, InvoiceServiceImplUnitTest.class})
public class InvoiceServiceTests {
    @Test
    public void test() {
    }
}
