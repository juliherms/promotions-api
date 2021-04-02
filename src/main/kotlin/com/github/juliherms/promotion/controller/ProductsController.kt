package com.github.juliherms.promotion.controller

import com.github.juliherms.promotion.exception.ProductNotFoundException
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
        var product = service.getById(id) ?: throw ProductNotFoundException("produto ${id} não encontrado")
        return ResponseEntity(product,HttpStatus.OK)
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
     * List all paginated products
     */
    @GetMapping("")
    fun getAll(@RequestParam(required = false, defaultValue = "0") start: Int,
               @RequestParam(required = false, defaultValue = "3") size: Int ): ResponseEntity<List<Product>> {

        val list = this.service.getAll(start,size)
        val status = if(list.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list,status)
    }

    /**
     * Method responsible to return number os products
     */
    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String,Long>> =
            ResponseEntity.ok().body(mapOf("count" to this.service.count()))

    /**
     * Method responsible to list all products with name sorted
     */
    @GetMapping("/sorted")
    fun sorted() = this.service.geyAllSortedByName()

}
