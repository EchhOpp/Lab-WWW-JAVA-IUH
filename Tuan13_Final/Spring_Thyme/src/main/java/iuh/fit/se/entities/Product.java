package iuh.fit.se.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String descrpition;
    @Column(name = "register_date")
    private Date registerDate;
    private double price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String code, String name, String descrpition, Date registerDate, double price, Category category) {
        this.code = code;
        this.name = name;
        this.descrpition = descrpition;
        this.registerDate = registerDate;
        this.price = price;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", descrpition='" + descrpition + '\'' +
                ", registerDate=" + registerDate +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
