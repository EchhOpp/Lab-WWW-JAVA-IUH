package shopping.dao;

import java.util.List;

import shopping.entity.Product;

public interface ProductDao {
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public void addProduct(Product product);
}
