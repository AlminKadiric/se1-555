package at.aau.serg.exercises.bookstore.dao;

import at.aau.serg.exercises.bookstore.dao.impl.ListCustomerDao;
import at.aau.serg.exercises.bookstore.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerDaoTest {
    private ListCustomerDao lista=new ListCustomerDao();
    @Test
    public void insertTest(){
        Customer t=new Customer(1L,"Almin","Strasse 2");
        lista.insert(t);
        Assertions.assertEquals(1,lista.findAll().size());
    }
    @Test
    public void findCustomerByNameTest(){
        Customer t=new Customer(1L,"Almin","Strasse 2");
        lista.insert(t);
        Customer t2=new Customer(2L,"Alex","Strasse 1");
        lista.insert(t2);
        List<Customer> l= lista.findCustomerByName("Alex");
        Assertions.assertEquals(1,l.size());
    }
    @Test
    public void updateTest(){
        Customer t=new Customer(1L,"Almin","Strasse 2");
        lista.insert(t);
        Customer t2=new Customer(2L,"Alex","Strasse 1");
        lista.insert(t2);
        Customer t3=new Customer(2L,"Alex","Different address");
        t= lista.update(t3);
        Assertions.assertEquals(2,lista.findAll().size());
    }
    @Test
    public void deleteTest(){
        Customer t=new Customer(1L,"Almin","Strasse 2");
        lista.insert(t);
        Customer t2=new Customer(2L,"Alex","Strasse 1");
        lista.insert(t2);
        lista.delete(2L);
        Assertions.assertEquals(1,lista.findAll().size());
    }
}
