package com.github.juliherms.promotion.service

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.repository.ProductRepository
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
    fun getAll(): List<Product> {
        return this.produtRepository.findAll().toList()
    }
}