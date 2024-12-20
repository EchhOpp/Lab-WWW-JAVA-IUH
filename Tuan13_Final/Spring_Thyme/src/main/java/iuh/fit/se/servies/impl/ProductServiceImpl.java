package iuh.fit.se.servies.impl;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.CategoryRepository;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.servies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
       return productRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(int id) {
       try{
           productRepository.deleteById(id);
           return true;
       } catch (Exception e) {
           return false;
       }
    }

    @Override
    public Boolean edit(Product product) {
        if(productRepository.existsById(product.getId()))
            productRepository.save(product);
        return null;
    }

    @Override
    public Boolean addProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> findByKey(String key) {
        return productRepository.findProductsByNameContaining(key);
    }

    @Override
    public Page<Product> findWithSelect(int category, Pageable pageable) {
        return productRepository.findProductsByCategory_Id(category, pageable);
    }
}
