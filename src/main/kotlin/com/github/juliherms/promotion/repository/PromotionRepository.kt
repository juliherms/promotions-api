package com.github.juliherms.promotion.repository

import com.github.juliherms.promotion.model.Product
import com.github.juliherms.promotion.model.Promotion
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**
 * Class responsible to access entity promotion
 */
@Repository
interface PromotionRepository  : PagingAndSortingRepository<Promotion, Long> {

}