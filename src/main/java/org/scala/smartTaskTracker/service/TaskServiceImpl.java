package org.scala.smartTaskTracker.service;

import org.scala.smartTaskTracker.entity.Category;
import org.scala.smartTaskTracker.entity.Task;
import org.scala.smartTaskTracker.repositories.CategoryRepository;
import org.scala.smartTaskTracker.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Task createTask(Task task, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if(category != null){
            task.setCategory(category);
            return taskRepo.save(task);
        }else{
            return null;
        }
    }

    @Override
    public List<Task> listAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public List<Task> fetchTasksByCategory(Long categoryId) {
        return taskRepo.findAll().stream().filter(t -> t.getCategory().getId().equals(categoryId)).toList();
    }

    @Override
    public Task fetchTaskById(long id) {
        return taskRepo.findById(id).orElse(null);
    }

    @Override
    public Task updateTask(long id, Task task) {
        Task taskToUpdate = taskRepo.findById(id).orElse(null);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setDueDate(task.getDueDate());
        taskToUpdate.setPriority(task.getPriority());
        taskToUpdate.setCompleted(task.isCompleted());

        return taskRepo.save(taskToUpdate);
    }

    @Override
    public void deleteTask(long id) {
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
        }
    }
}
