package com.github.juliherms.promotion.repository

import com.github.juliherms.promotion.model.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * This class responsible to access table Product
 */
@Repository
interface ProductRepository : PagingAndSortingRepository<Product,Long> {

    @Query(value = "select p from Product p WHERE UPPER(p.name) LIKE %:name%")
    fun findByNameLike(@Param("name") name : String) : List<Product>
}