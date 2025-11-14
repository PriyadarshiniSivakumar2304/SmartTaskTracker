package org.scala.smartTaskTracker.controller;

import org.scala.smartTaskTracker.entity.Category;
import org.scala.smartTaskTracker.entity.Task;
import org.scala.smartTaskTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.listAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id) {
        return categoryService.fetchCategoryById(id);
    }

    @PostMapping()
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategoryName(@PathVariable long id, @RequestBody Category category) {
        return categoryService.updateCategoryName(id, category.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}
