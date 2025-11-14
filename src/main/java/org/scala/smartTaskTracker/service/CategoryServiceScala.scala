package org.scala.smartTaskTracker.service

import org.scala.smartTaskTracker.entity.Category

trait CategoryServiceScala {
  def createCategory(category: Category): Category

  def listAllCategories(): java.util.List[Category]

  def fetchCategoryById(id: Long): Category

  def updateCategoryName(id: Long, name: String): Category

  def deleteCategory(id: Long): Unit
}
