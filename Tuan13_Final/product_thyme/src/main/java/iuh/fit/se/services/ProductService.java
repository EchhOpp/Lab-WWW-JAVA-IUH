package iuh.fit.se.services;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<Product> findALlWithPage(Pageable pageable);
    public List<Product> findByKey(String key);
    public Product findById(int id);
    public Boolean delete(int id);
    public Boolean update(Product product);
    public Boolean addProduct(Product product);
    public Page<Product> findProductByCate(int category_id, Pageable pageable);
    public List<Category> findAllCategory();
}
