package com.github.juliherms.promotion.controller

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * This class responsible to provide products endpoint
 */
@RestController
@RequestMapping(value = ["/products"])
class ProductsController {

    @Autowired
    lateinit var  service: ProductService

    /**
     * Find products by id
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Product?> {
        var product = service.getById(id)
        var status = if(product == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(product,status)
    }

    /**
     * create products
     */
    @PostMapping()
    fun create (@RequestBody product: Product): ResponseEntity<Unit> {
        service.create(product)
        return ResponseEntity(Unit,HttpStatus.CREATED)
    }

    /**
     * delete products
     */
    fun delete (@PathVariable id: Long): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if(service.getById(id) != null){
            status = HttpStatus.ACCEPTED
            this.service.remove(id)
        }
        return ResponseEntity(Unit,status)
    }

    /**
     * Update products
     */
    @PutMapping("/{id}")
    fun update (@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if(service.getById(id) != null){
            service.update(id,product)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit,status)
    }

    /**
     * Find products by description
     */
    @GetMapping("")
    fun listAll(@RequestParam(required = false, defaultValue = "") description: String): ResponseEntity<List<Product>> {
        var status = HttpStatus.OK
        val listProducts = service.filter(description)

        if(listProducts.isEmpty()){
            status = HttpStatus.NOT_FOUND
        }

        return ResponseEntity(listProducts,status)
    }

}
