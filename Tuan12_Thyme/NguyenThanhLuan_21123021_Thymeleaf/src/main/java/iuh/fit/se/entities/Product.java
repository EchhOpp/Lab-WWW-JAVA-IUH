package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="Code")
    @Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[0-2])", message = "Code must follow the pattern ProXXX-MM")
    private String code;
    @Column(name="Name")
    @Size(max = 20, message = "Name must be at most 20 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only letters")
    private String name;
    @Column(name="Description")
    @NotNull
    @NotEmpty
    private String description;
    @Column(name="Register_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Register date must be a past date")
    private Date registerDate;
    @Column(name="Price")
    @Positive(message = "Price must be gzreater than 0")
    private double price;
    @ManyToOne()
    @JoinColumn(name = "CART_ID")
    private Category category;

    public Product() {
    }
    public Product(String code, String name, Date registerDate, String description, double price) {
        this.code = code;
        this.name = name;
        this.registerDate = registerDate;
        this.description = description;
        this.price = price;
    }

    public Product(double price, Date registerDate, String description, String name, String code, int id) {
        this.price = price;
        this.registerDate = registerDate;
        this.description = description;
        this.name = name;
        this.code = code;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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
                '}';
    }
}
