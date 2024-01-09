package at.aau.serg.exercises.bookstore.dao.impl;

import at.aau.serg.exercises.bookstore.dao.InvoiceDao;
import at.aau.serg.exercises.bookstore.entity.Invoice;

public class ListInvoiceDao extends ListDao<Invoice> implements InvoiceDao {

	public ListInvoiceDao() {
		this.currentId = 1L;
	}
}
