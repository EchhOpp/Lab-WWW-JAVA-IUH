package iuh.fit.se.services;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> search(String keyword, Pageable pageable);
    Product findById(int id);
    void save(Product product);
    void delete(int id);
}