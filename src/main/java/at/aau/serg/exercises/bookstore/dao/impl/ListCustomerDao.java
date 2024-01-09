package at.aau.serg.exercises.bookstore.dao.impl;

import at.aau.serg.exercises.bookstore.dao.CustomerDao;
import at.aau.serg.exercises.bookstore.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class ListCustomerDao extends ListDao<Customer> implements CustomerDao {
    public ListCustomerDao() {
        this.currentId = 1L;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return list.stream()
                .filter(customer -> name.equals(customer.getName()))
                .collect(Collectors.toList());
    }


}
