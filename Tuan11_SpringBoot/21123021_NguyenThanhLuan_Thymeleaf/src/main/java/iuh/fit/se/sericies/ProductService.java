package iuh.fit.se.sericies;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Page<Product> getAllProductsWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
    public Product getProductByKey(String key);
    public Product save(Product product);
    public Product update(Product product);
    public boolean delete(String key);
}
