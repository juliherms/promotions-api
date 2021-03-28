package com.github.juliherms.promotion.repository

import com.github.juliherms.promotion.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * This class responsible to access table Product
 */
@Repository
interface ProductRepository : CrudRepository<Product,Long> {

}