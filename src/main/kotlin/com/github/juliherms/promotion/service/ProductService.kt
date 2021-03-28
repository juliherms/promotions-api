package com.github.juliherms.promotion.service

import com.github.juliherms.promotion.model.Product
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ProductService {

    companion object {
        val initialProducts = arrayOf(
                Product(1, "Ração Royal Canin Club Performance Cães Adultos"),
                Product(2, "Ração Premier Raças Específicas Golden Retriever para Cães Adultos"),
                Product(3,"Antipulgas e Carrapatos Bravecto MSD para Cães até 4,5 kg")
            )
        }

    var products =  ConcurrentHashMap<Long,Product>(initialProducts.associateBy( Product::id ))

    /**
     * Method responsible to create product
     */
    fun create(product: Product) {
        products[product.id] = product
    }

    /**
     * Method responsible to get product by id
     */
    fun getById(id: Long): Product? {
        return products[id]
    }

    /**
     * Method responsible to update product
     */
    fun update(id: Long, product:Product){
        products.remove(id)
        products[id] = product
    }

    /**
     * Method responsible to remove product
     */
    fun remove (id: Long) {
        products.remove(id)
    }

    /**
     * Method responsible to filter product
     */
    fun filter (description: String)  =
            products.filter {
                it.value.description.contains(description,true)
            }.map (Map.Entry<Long,Product>::value).toList()

}