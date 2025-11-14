package org.scala.smartTaskTracker.controller;

import org.scala.smartTaskTracker.repositories.TaskRepository;
import org.scala.smartTaskTracker.service.TaskService;
import org.scala.smartTaskTracker.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") long id) {
        return taskService.fetchTaskById(id);
    }

    @GetMapping("/categories/{id}/tasks")
    public List<Task> getTasksByCategory(@PathVariable long id) {
        return taskService.fetchTasksByCategory(id);
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task, task.getCategory().getId());
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") long id) {
        taskService.deleteTask(id);
    }

}
