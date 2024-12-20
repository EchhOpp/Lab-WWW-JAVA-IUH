package iuh.fit.se.servies;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<Product> findAll(Pageable pageable);
    public Product findById(int id);
    public Boolean delete(int id);
    public Boolean edit(Product product);
    public Boolean addProduct(Product product);
    public List<Category> findAllCategory();
    public List<Product> findByKey(String key);

    public Page<Product> findWithSelect(int category, Pageable pageable);
}
