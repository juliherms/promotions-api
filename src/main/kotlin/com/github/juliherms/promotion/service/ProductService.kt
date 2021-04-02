package com.github.juliherms.promotion.service

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

/**
 * This class responsible to implement business logic to access product repository
 * in this case I'm prefer use dependency injection with constructor
 */
@Component
class ProductService(val produtRepository:ProductRepository) {

    /**
     * Method responsible to create product
     */
    fun create(product: Product) {
        this.produtRepository.save(product)
    }

    /**
     * Method responsible to get product by id
     */
    fun getById(id: Long): Product? {
        return this.produtRepository.findById(id).orElseGet(null)
    }

    /**
     * Method responsible to update product
     */
    fun update(id: Long, product:Product){
        create(product)
    }

    /**
     * Method responsible to remove product
     */
    fun remove (id: Long) {
        this.produtRepository.deleteById(id)
    }

    /**
     * Method responsible to filter product
     */
    fun filter (description: String)  = null

    /**
     * Method responsible to list all products
     */
    fun getAll(start: Int, size: Int): List<Product> {
        val pages: Pageable = PageRequest.of(start,size, Sort.by("name").ascending())
        return this.produtRepository.findAll(pages).toList()
    }

    /**
     * Method Responsible to capture count for products
     */
    fun count(): Long = this.produtRepository.count()

    /**
     * Method responsible to list all products sorted
     */
    fun geyAllSortedByName(): List<Product> = this.produtRepository.findAll(Sort.by("name").descending()).toList()
}