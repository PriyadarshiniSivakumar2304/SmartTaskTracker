package org.scala.smartTaskTracker.service

import org.scala.smartTaskTracker.entity.Task
import org.scala.smartTaskTracker.repositories.TaskRepository
import org.scala.smartTaskTracker.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import scala.jdk.CollectionConverters._

@Service
@Primary // <- This lets us use scala ver to test
@Autowired
class TaskServiceScalaImpl(val taskRepo: TaskRepository, val categoryRepo: CategoryRepository)
extends TaskServiceScala {

  override def createTask(task: Task, categoryId: Long): Task = {
    val category = categoryRepo.findById(categoryId).orElse(null)
    task.setCategory(category)
    taskRepo.save(task)
  }

  override def listAllTasks: java.util.List[Task] = {
    taskRepo.findAll().toArray().toList.asInstanceOf[List[Task]].asJava
  }

  override def fetchTasksByCategory(categoryId: Long): java.util.List[Task] = {
    taskRepo.findAll()
      .toArray()
      .map(_.asInstanceOf[Task])
      .filter(task => task.getCategory != null && task.getCategory.getId == categoryId)
      .toList
      .asInstanceOf[List[Task]].asJava
  }

  override def fetchTaskById(id: Long): Task = {
    taskRepo.findById(id).orElse(null)
  }

  override def updateTask(id: Long, task: Task): Task = {
    val taskToUpdate = taskRepo.findById(id).orElse(null)
    taskToUpdate.setTitle(task.getTitle)
    taskToUpdate.setDescription(task.getDescription)
    taskToUpdate.setDueDate(task.getDueDate)
    taskToUpdate.setPriority(task.getPriority)
    taskToUpdate.setCompleted(task.isCompleted)

    taskRepo.save(taskToUpdate)
  }

  override def deleteTask(id: Long): Unit = {
    if (taskRepo.existsById(id)) {
      taskRepo.deleteById(id)
    }
  }
}
