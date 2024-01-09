package at.aau.serg.exercises.bookstore.entity;

import at.aau.serg.exercises.bookstore.dao.EntityWithId;

import java.util.List;
import java.util.Objects;

public class Invoice implements EntityWithId<Long> {

	private Long id;
	private Customer customer;
	private List<Book> books;
	private Boolean paid;

	public Invoice() {
	}

	public Invoice(Long id, Customer customer, List<Book> items, Boolean paid) {
		super();
		this.id = id;
		this.customer = customer;
		this.books = items;
		this.paid = paid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Invoice invoice = (Invoice) o;
		return Objects.equals(id, invoice.id) && Objects.equals(customer, invoice.customer) && Objects.equals(books, invoice.books) && Objects.equals(paid, invoice.paid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, customer, books, paid);
	}

	@Override
	public String toString() {
		return "Invoice{" +
				"id=" + id +
				", customer=" + customer +
				", books=" + books +
				", paid=" + paid +
				'}';
	}
}
