package bookstore.dao;

import java.util.List;

import bookstore.entity.DetailBill;

public interface BillDao {
	public List<DetailBill> getAllDetailBill();
	public DetailBill getDetailBill(int id);
	public void insertDetailBill(int idBill, int idBook, int quantity);
}
