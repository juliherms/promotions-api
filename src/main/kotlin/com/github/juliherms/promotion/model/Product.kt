package com.github.juliherms.promotion.model

import javax.persistence.*

/**
 * This class represents product in the system
 */
@Entity
@Table(name = "TB_PRODUCT")
data class Product(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 1L,
        val name: String = "",
        val description: String = ""
)
