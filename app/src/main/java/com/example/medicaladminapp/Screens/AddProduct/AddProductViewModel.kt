package com.example.medicaladminapp.Screens.AddProduct

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicaladminapp.API.RetrofitInstance
import com.example.medicaladminapp.DataModel.CreateProductResponse
import kotlinx.coroutines.launch

class AddProductViewModel : ViewModel() {
    var state = mutableStateOf<String?>(null)
    val addProductRes = mutableStateOf<CreateProductResponse?>(null)
//
//    fun productsAdd(
//        name: String,
//        certified: String,
//        stack: String,
//        price: String,
//        category: String,
//    ) {
//        viewModelScope.launch {
//            addProductRes.value = createProduct(
//            name, certified, stack, price, category
//        )
//        }
//    }

    init {
        state.value = State.DEFAULT.name
    }

    fun setDefault() {
        state.value = State.DEFAULT.name
    }

    fun createProducts(
        name: String,
        price: String,
        stock: String,
        category: String,
        certified: String
    ) {
        viewModelScope.launch {
            createProduct(
                name = name,
                price = price,
                stock = stock,
                category = category,
                certified = certified
            )
        }
    }

    suspend fun createProduct(
        name: String,
        price: String,
        stock: String,
        category: String,
        certified: String
    ) {
        state.value = State.LOADING.name

        val result = RetrofitInstance.api.createProduct(
            productName = name,
            productPrice = price,
            productCategory = category,
            productStock = stock,
            productCertified = certified
        )
        if (result.isSuccessful) {
            if (result.body()?.status == 200) {
                state.value = State.SUCCESS.name
            } else {
                state.value = State.FAILED.name
            }
        } else {
            state.value = State.FAILED.name
        }
    }
}


sealed class State(val name: String) {
    data object DEFAULT : State("default")
    data object FAILED : State("failed")
    data object SUCCESS : State("success")
    data object LOADING : State("loading")
}
