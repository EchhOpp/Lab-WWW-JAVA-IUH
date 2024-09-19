package shopping.dao;

import java.util.List;

import shopping.entity.Product;

public interface ProductDao {
	public List<Product> findAll();
	public Product findById(int id);
	public void insert(Product product);
}
