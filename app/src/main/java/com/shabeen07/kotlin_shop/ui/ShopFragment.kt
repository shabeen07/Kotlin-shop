package com.shabeen07.kotlin_shop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.shabeen07.kotlin_shop.R
import com.shabeen07.kotlin_shop.ShopAdapter
import com.shabeen07.kotlin_shop.databinding.FragmentShopBinding
import com.shabeen07.kotlin_shop.models.ProductDto
import com.shabeen07.kotlin_shop.viewmodels.ShopViewModel

class ShopFragment : Fragment() {

    private lateinit var shopViewModel: ShopViewModel
    private lateinit var shopBinding: FragmentShopBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        shopBinding = FragmentShopBinding.inflate(inflater, container, false)
        shopViewModel = ViewModelProvider(requireActivity())[ShopViewModel::class.java]
        return shopBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMenu()
        initUI()
        navController = Navigation.findNavController(view)
        shopViewModel.products.observe(requireActivity()) {
            if (it != null) {
                setAdapter(it)
            }
        }
    }

    private fun initUI() {
        shopBinding.productList.layoutManager = GridLayoutManager(requireActivity(), 2)
        shopBinding.productList.itemAnimator = DefaultItemAnimator()
    }

    private fun setAdapter(productList: List<ProductDto>) {
        val productAdapter = ShopAdapter(productList)
        shopBinding.productList.adapter = productAdapter
    }

    private fun setUpMenu() {
        val menuProvider: MenuProvider = object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.shop_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.cartFragment -> {
                        navController.navigate(R.id.action_shopFragment_to_itemDetailFragment)
                    }
                }
                return true
            }

        }
        requireActivity().addMenuProvider(menuProvider, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

}