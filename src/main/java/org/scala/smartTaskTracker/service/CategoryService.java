package org.scala.smartTaskTracker.service;

import org.scala.smartTaskTracker.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> listAllCategories();
    Category fetchCategoryById(Long id);
    Category updateCategoryName(Long id, String name);
    void deleteCategory(Long id);
}
