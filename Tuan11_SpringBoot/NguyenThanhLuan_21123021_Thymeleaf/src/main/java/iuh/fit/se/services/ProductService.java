package iuh.fit.se.services;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProduct();
    public Page<Product> getAllProductPagination(int page, int size);

    public Product searchID(int id);

    public List<Product> findByPrice(double price);
    public List<Product> findByRegisterDate(Date registerDate);
    public Optional<Product> findByCategory_Id(int categoryId);

    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);

    public Product findProductById(int id);

    public List<Product> findByNameLike(String name);

    List<Product> searchName(String name);

    List<Product> searchDate(Date date);
}
