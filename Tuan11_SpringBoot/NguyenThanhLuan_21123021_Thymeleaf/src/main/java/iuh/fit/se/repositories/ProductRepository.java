package iuh.fit.se.repositories;

import iuh.fit.se.entities.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findById(int id);
    List<Product> findByNameLikeIgnoreCase(String name);
    List<Product> findByPrice(@Param("price") double price);

    @Query("SELECT P FROM Product P WHERE P.name LIKE %:name%")
    List<Product> getProductByNameLike(@Size(min = 1,max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ") String name);

    List<Product> findByRegisterDate(@Past(message = "trước ngày hiện tại") Date registerDate);

    Product findByName(@Size(min = 1,max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ") @Pattern(regexp = "^[a-zA-Z]*$") String name);

    Product findByNameLike(@Size(min = 1,max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ") @Pattern(regexp = "^[a-zA-Z]*$") String name);

    @Query("SELECT P FROM Product P WHERE P.registerDate = :registerDate")
    List<Product> searchProductByRegisterDate(@Past(message = "trước ngày hiện tại") Date registerDate);

    @Query("SELECT p FROM Product p WHERE p.registerDate BETWEEN :startDate AND :endDate")
    List<Product> searchProductByDateRange(
            @Past(message = "Start date must be in the past") Date startDate,
            @Past(message = "End date must be in the past") Date endDate
    );
}
