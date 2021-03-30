package com.github.juliherms.promotion.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.Date;
import javax.persistence.*

/**
 * This class responsible to represents promotion
 */
@Entity
@Table(name = "TB_PROMOTION")
data class Promotion(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 1L,
        val name: String = "",
        val amount: Float? = 0.0f,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
        val initialDate: Date = Date(),
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
        val expiredDate: Date = Date()
)
