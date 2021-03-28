package com.github.juliherms.promotion.controller

import com.github.juliherms.promotion.model.Promotion
import com.github.juliherms.promotion.service.PromotionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * This class responsible to provide promotions endpoint
 */
@RestController
@RequestMapping(value = ["/promotions"])
class PromotionsController {

    @Autowired
    lateinit var  service: PromotionService

    /**
     * Find promotions by id
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Promotion?> {
        var promotion = service.getById(id)
        var status = if(promotion == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promotion,status)
    }

    /**
     * create promotions
     */
    @PostMapping()
    fun create (@RequestBody promotion: Promotion): ResponseEntity<Unit> {
        service.create(promotion)
        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    /**
     * delete promotions
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
     * Update promotions
     */
    @PutMapping("/{id}")
    fun update (@PathVariable id: Long, @RequestBody promotion: Promotion): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if(service.getById(id) != null){
            service.update(id,promotion)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit,status)
    }

    /**
     * Find promotions by name
     */
    @GetMapping("")
    fun listAll(@RequestParam(required = false, defaultValue = "") description: String): ResponseEntity<List<Promotion>> {
        var status = HttpStatus.OK
        val listPromotions = service.filter(description)

        if(listPromotions.isEmpty()){
            status = HttpStatus.NOT_FOUND
        }

        return ResponseEntity(listPromotions,status)
    }
}
