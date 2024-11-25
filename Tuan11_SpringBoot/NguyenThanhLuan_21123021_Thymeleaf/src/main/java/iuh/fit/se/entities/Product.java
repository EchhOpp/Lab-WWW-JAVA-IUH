
package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    @Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[1-9])", message = "ProXXX-MM (Trong đó X: ký tự số, MM: từ 01-12) ")
    private String code;
    @Column(name = "name")
    @Size(min = 1,max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ")
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String name;

    @Column(name = "description")
    @NotEmpty
    @NotNull
    private String description;

    @Column(name = "register_date")
    @Past(message = "trước ngày hiện tại")
    private Date registerDate;

    @Column(name = "price")
    @DecimalMin(value = "0.0", inclusive = false, message = "là số thực >0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Category category;

    public Product() {
    }

    public Product(String code, String name, String description, Date registerDate, double price, Category category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.registerDate = registerDate;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[1-9])", message = "ProXXX-MM (Trong đó X: ký tự số, MM: từ 01-12) ") String getCode() {
        return code;
    }

    public void setCode(@Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[1-9])", message = "ProXXX-MM (Trong đó X: ký tự số, MM: từ 01-12) ") String code) {
        this.code = code;
    }

    public @Size(min = 1, max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ") @Pattern(regexp = "^[a-zA-Z]*$") String getName() {
        return name;
    }

    public void setName(@Size(min = 1,max = 20, message = "Toi da 20 ký tự chữ hoa hoặc thường  ") @Pattern(regexp = "^[a-zA-Z]*$") String name) {
        this.name = name;
    }

    public @NotEmpty @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty @NotNull String description) {
        this.description = description;
    }

    public @Past(message = "trước ngày hiện tại") Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@Past(message = "trước ngày hiện tại") Date registerDate) {
        this.registerDate = registerDate;
    }

    public @DecimalMin(value = "0.0", inclusive = false, message = "là số thực >0") double getPrice() {
        return price;
    }

    public void setPrice(@DecimalMin(value = "0.0", inclusive = false, message = "là số thực >0") double price) {
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
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registerDate=" + registerDate +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
