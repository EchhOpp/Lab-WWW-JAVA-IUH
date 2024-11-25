package iuh.fit.se.sericies.impl;

import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.sericies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.getProductByCartId(id);
    }

    @Override
    public Page<Product> getAllProductsWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return productRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Product> getProductByKey(int id, String name, String code, java.sql.Date date, double price) {
        return List.of();
    }

    public List<Product> getProductByKey(int id, String name, String code, Date date, double price) {
        return productRepository.searchProductByKey(id, name, code, date, price);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getCartId())) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        if(productRepository.existsById(Integer.parseInt(key))) {
            productRepository.deleteById(Integer.parseInt(key));
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getProductByNameLike(String name) {
        return productRepository.getProductByNameLike(name);
    }

    @Override
    public List<Product> getProductByDate(java.sql.Date date) {
        return List.of();
    }

    @Override
    public List<Product> getProductByDate(Date date) {
        return productRepository.getProductByDate(date);
    }
}
