package at.aau.serg.exercises.bookstore.dao;

import java.util.List;

import at.aau.serg.exercises.bookstore.entity.Customer;

public interface CustomerDao extends Dao<Long, Customer> {
	public List<Customer> findCustomerByName(String name);
}
