package org.scala.smartTaskTracker.service

import org.scala.smartTaskTracker.entity.Task

trait TaskServiceScala {
  def createTask(task: Task, categoryId: Long): Task
  def listAllTasks: java.util.List[Task]
  def fetchTasksByCategory(categoryId: Long): java.util.List[Task]
  def fetchTaskById(id: Long): Task
  def updateTask(id: Long, task: Task): Task
  def deleteTask(id: Long): Unit
}
