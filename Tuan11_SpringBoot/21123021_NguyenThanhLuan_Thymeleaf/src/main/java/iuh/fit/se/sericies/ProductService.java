package iuh.fit.se.sericies;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;


import java.sql.Date;
import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductByID(int id);
    public Page<Product> getAllProductsWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
    public List<Product> getProductByKey(int id, String name, String code, Date date,double price);
    public Product save(Product product);
    public Product update(Product product);
    public boolean delete(String key);

    public List<Product> getProductByNameLike(String name);

    List<Product> getProductByDate(Date date);

    List<Product> getProductByDateva.util.Date date);
}
