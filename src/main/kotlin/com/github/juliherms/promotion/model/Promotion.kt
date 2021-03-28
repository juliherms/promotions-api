package com.github.juliherms.promotion.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.Date;

/**
 * This class responsible to represents promotion
 */
data class Promotion(
        val id: Long,
        val name: String,
        val amount: Float? = 0.0f,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val initialDate: Date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val expiredDate: Date
)
