package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProductPagination(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Product searchID(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findByRegisterDate(Date registerDate) {
        return productRepository.findByRegisterDate(registerDate);
    }

    @Override
    public Optional<Product> findByCategory_Id(int categoryId) {
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByNameLikeIgnoreCase(name);
    }

    @Override
    public List<Product> searchName(String name) {
        return productRepository.getProductByNameLike(name);
    }

    @Override
    public List<Product> searchDate(Date date) {
        return productRepository.searchProductByRegisterDate(date);
    }
}
