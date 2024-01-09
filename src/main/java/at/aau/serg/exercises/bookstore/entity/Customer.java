package at.aau.serg.exercises.bookstore.entity;

import at.aau.serg.exercises.bookstore.dao.EntityWithId;

import java.util.Objects;

public class Customer implements EntityWithId<Long> {
	private Long id;
	private String name;
	private String address;

	public Customer() {
	}

	public Customer(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(address, customer.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
