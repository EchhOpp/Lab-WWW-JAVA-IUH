package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @Column(name = "code")
    @Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[0-2])", message = "Code must be in format ProXXX-YY")
    private String code;

    @Column(name = "name")
    @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must be in alphabet")
    private String name;

    @Column(name = "description")
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "register_date")
    @Past(message = "Register date must be in the past")
    private Date registerDate;

    @Column(name = "price")
    @DecimalMin(value = "0.0", inclusive = false,message = "Price must be greater than 0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String code, String name, String description, String registerDate, double price, Category category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.registerDate = registerDate;
        this.price = price;
        this.category = category;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cartId=" + cartId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
