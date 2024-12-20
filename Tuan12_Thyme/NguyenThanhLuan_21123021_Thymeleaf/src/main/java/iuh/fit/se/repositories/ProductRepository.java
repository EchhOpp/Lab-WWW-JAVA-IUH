package iuh.fit.se.repositories;

import iuh.fit.se.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByNameContainingOrCodeContaining(String name, String code, Pageable pageable);
}
