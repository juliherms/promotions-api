package com.github.juliherms.promotion.service

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.model.Promotion
import com.github.juliherms.promotion.repository.ProductRepository
import com.github.juliherms.promotion.repository.PromotionRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * This class responsible to provide business logic to entity promotion
 */
@Component
class PromotionService (val promotionRepository: PromotionRepository) {

    /**
     * Method responsible to create promotion
     */
    fun create(promotion: Promotion) {
        this.promotionRepository.save(promotion)
    }

    /**
     * Method responsible to get promotion by id
     */
    fun getById(id: Long): Promotion? {
        return this.promotionRepository.findById(id).orElseGet(null)
    }

    /**
     * Method responsible to update promotion
     */
    fun update(id: Long, promotion: Promotion){
        create(promotion)
    }

    /**
     * Method responsible to remove promotion
     */
    fun remove (id: Long) {
        this.promotionRepository.deleteById(id)
    }

    /**
     * Method responsible to filter promotion
     */
    fun filter (description: String)  = null

    /**
     * Method responsible to list all promotions
     */
    fun getAll(start: Int, size: Int): List<Promotion> {
        val pages: Pageable = PageRequest.of(start,size)
        return this.promotionRepository.findAll(pages).toList()
    }

    /**
     * Method Responsible to capture count for promotions
     */
    fun count(): Long = this.promotionRepository.count()
}