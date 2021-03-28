package com.github.juliherms.promotion.repository

import com.github.juliherms.promotion.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This class responsible to access table Product
 */
@Repository
interface ProductRepository : JpaRepository<Product,Long> {

}