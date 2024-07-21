package com.shabeen07.kotlin_shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shabeen07.kotlin_shop.databinding.ProductListItemBinding
import com.shabeen07.kotlin_shop.models.ProductDto

class ShopAdapter(private val productList: List<ProductDto>) :
    RecyclerView.Adapter<ShopAdapter.MyHolder>() {


    class MyHolder(val productListItemBinding: ProductListItemBinding) :
        RecyclerView.ViewHolder(productListItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val product = productList[position]
        holder.productListItemBinding.name.text = product.productName
        holder.productListItemBinding.price.text = product.price.toPlainString()
    }
}