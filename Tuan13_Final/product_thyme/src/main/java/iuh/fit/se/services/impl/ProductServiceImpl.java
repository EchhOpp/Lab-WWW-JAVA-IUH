package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.CategoryRepository;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> findALlWithPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findByKey(String key) {
        return productRepository.findProductsByNameContaining(key);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findProductsById(id);
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
    public Boolean update(Product product) {
        if(productRepository.existsById(product.getId())){
            productRepository.save(product);
            return true;
        }
        return null;
    }

    @Override
    public Boolean addProduct(Product product) {
        if(product!=null)
            productRepository.save(product);
        return null;
    }

    @Override
    public Page<Product> findProductByCate(int category_id, Pageable pageable) {
        return productRepository.findProductsByCategory_id(category_id, pageable);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
