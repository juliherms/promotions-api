package com.github.juliherms.promotion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PromotionApiApplication

fun main(args: Array<String>) {
	runApplication<PromotionApiApplication>(*args)
}
