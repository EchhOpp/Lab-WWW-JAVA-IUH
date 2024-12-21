package iuh.fit.se.repositories;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByNameContaining(String name);

    Product findProductsById(int id);

    Page<Product> findProductsByCategory_id(int categoryId, Pageable pageable);
}
