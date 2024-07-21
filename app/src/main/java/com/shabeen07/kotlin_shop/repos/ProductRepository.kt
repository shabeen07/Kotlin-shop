package com.shabeen07.kotlin_shop.repos

import com.shabeen07.kotlin_shop.models.ProductDto
import java.math.BigDecimal

class ProductRepository {
    val products = listOf(
        ProductDto(1, "Iphone 10", BigDecimal(10.0)),
        ProductDto(2, "Iphone 11", BigDecimal(20.0)),
        ProductDto(3, "Ipad Pro", BigDecimal(30.0)),
        ProductDto(4, "Macbook Pro", BigDecimal(40.0)),
        ProductDto(5, "Macbook Air", BigDecimal(50.0)),
        ProductDto(6, "Macbook Pro 13", BigDecimal(60.0)),
        ProductDto(7, "Macbook Pro 16", BigDecimal(70.0)),
        ProductDto(8, "Macbook Pro 17", BigDecimal(80.0)),
        ProductDto(9, "Macbook Pro 18", BigDecimal(90.0)),
        ProductDto(10, "Macbook Pro 19", BigDecimal(100.0)),
        ProductDto(11, "Macbook Pro 20", BigDecimal(110.0)),
        ProductDto(12, "Macbook Pro 21", BigDecimal(120.0)),
    )
}