package org.scala.smartTaskTracker.service

import org.scala.smartTaskTracker.entity.Category
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.scala.smartTaskTracker.repositories.CategoryRepository
import scala.jdk.CollectionConverters._

@Service
@Autowired
class CategoryServiceScalaImpl(val categoryRepository: CategoryRepository)
  extends CategoryServiceScala {
  override def createCategory(category: Category): Category = {
    categoryRepository.save(category)
  }

  override def listAllCategories(): java.util.List[Category] = {
    categoryRepository.findAll().toArray().toList.asInstanceOf[List[Category]].asJava
  }

  override def fetchCategoryById(id: Long): Category = {
    categoryRepository.findById(id).orElse(null)
  }

  override def updateCategoryName(id: Long, name: String): Category = {
    val category = categoryRepository.findById(id).orElse(null)
    if (category != null) {
      category.setName(name)
      categoryRepository.save(category)
    }
    return category
  }

  override def deleteCategory(id: Long): Unit = {
    val category = categoryRepository.findById(id).orElse(null)
    if (category != null) {
      categoryRepository.deleteById(id)
    }
  }
}
