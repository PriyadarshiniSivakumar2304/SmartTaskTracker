package org.scala.smartTaskTracker.service;

import org.scala.smartTaskTracker.entity.Category;
import org.scala.smartTaskTracker.entity.Task;
import org.scala.smartTaskTracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category fetchCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategoryName(Long id, String name) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(name);
            return categoryRepository.save(category);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
