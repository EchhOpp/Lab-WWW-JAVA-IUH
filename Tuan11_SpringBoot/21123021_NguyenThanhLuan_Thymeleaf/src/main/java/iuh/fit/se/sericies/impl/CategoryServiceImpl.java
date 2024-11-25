package iuh.fit.se.sericies.impl;

import iuh.fit.se.repositories.CatogoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CatogoryRepository catogoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return catogoryRepository.findAll();
    }

}
