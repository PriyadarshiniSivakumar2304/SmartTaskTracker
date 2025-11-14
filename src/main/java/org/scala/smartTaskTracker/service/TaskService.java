package org.scala.smartTaskTracker.service;

import org.scala.smartTaskTracker.entity.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task, Long categoryId);

    List<Task> listAllTasks();

    List<Task> fetchTasksByCategory(Long categoryId);

    Task fetchTaskById(long id);

    Task updateTask(long id, Task task);

    void deleteTask(long id);


}
