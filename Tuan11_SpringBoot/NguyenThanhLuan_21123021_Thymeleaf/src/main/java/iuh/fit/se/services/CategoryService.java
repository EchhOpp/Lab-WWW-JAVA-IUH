package iuh.fit.se.services;

import iuh.fit.se.entities.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public boolean addCategory(Category category);

}
