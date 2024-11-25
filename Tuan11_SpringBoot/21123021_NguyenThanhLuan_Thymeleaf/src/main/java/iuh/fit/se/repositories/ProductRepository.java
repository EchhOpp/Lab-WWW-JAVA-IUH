package iuh.fit.se.repositories;

import iuh.fit.se.entities.Product;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT P FROM Product  P WHERE " +
            "P.cartId = :id " +
            "OR P.name LIKE %:name% " +
            "OR P.code LIKE %:code% " +
            "OR P.registerDate = :date " +
            "OR P.price = :price")
    public List<Product> searchProductByKey(@Param("id") int id, @Param("name") String name,@Param("code") String code,@Param("date") Date date,@Param("price") double price);

    Product getProductByCartId(int cartId);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> getProductByNameLike(@Param("name") String name);

    List<Product> getProductByDate(Date registerDate);

}
