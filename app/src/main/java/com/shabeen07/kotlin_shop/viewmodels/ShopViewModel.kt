package com.shabeen07.kotlin_shop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shabeen07.kotlin_shop.models.ProductDto
import com.shabeen07.kotlin_shop.repos.ProductRepository

class ShopViewModel: ViewModel() {

    private var _products = MutableLiveData<List<ProductDto>>()

    val products: MutableLiveData<List<ProductDto>> = _products

    private val productRepository: ProductRepository = ProductRepository()
    init {
        _products.value = productRepository.products
    }

}