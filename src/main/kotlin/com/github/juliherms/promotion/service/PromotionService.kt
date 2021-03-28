package com.github.juliherms.promotion.service

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.model.Promotion
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * This class responsible to provide business logic to entity promotion
 */
@Component
class PromotionService {

    companion object {
        val initialPromotions = arrayOf(
                Promotion(1L,"Produtos com 20% de desconto",20F, Date(),Date()),
        )
    }

    var promotions =  ConcurrentHashMap<Long, Promotion>(initialPromotions.associateBy( Promotion::id ))

    /**
     * Create promotion
     */
    fun create(promotion: Promotion) {
        promotions[promotion.id] = promotion
    }

    /**
     * Find promotion by id
     */
    fun getById(id: Long): Promotion? {
        return promotions[id]
    }

    /**
     * update promotion
     */
    fun update(id: Long, promotion:Promotion){
        promotions.remove(id)
        promotions[id] = promotion
    }

    /**
     * Remove promotion
     */
    fun remove (id: Long) {
        promotions.remove(id)
    }

    /**
     * Filter promotion by name
     */
    fun filter (name: String)  =
            promotions.filter {
                it.value.name.contains(name,true)
            }.map (Map.Entry<Long,Promotion>::value).toList()

}