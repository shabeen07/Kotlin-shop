package com.shabeen07.kotlin_shop.models

import java.math.BigDecimal

data class ProductDto(
    val productId: Int,
    val productName: String,
    val price: BigDecimal
) {
    override fun toString(): String {
        return "ProductDto(productId=$productId, productName='$productName', price=$price)"
    }
}
