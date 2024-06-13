package com.example.medicaladminapp.Screens.Orders

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicaladminapp.API.RetrofitInstance
import com.example.medicaladminapp.API.RetrofitInstance.api
import com.example.medicaladminapp.DataModel.UserDataItem
import com.example.medicalvendorapp.DataModel.ProductResponseItem
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {
    val productResponse = mutableStateOf<List<ProductResponseItem?>>(emptyList())

    init {
        viewModelScope.launch {
//            state.value = States.LOADING.name
            productResponse.value = getAllProductFromAPI()
            Log.d("PRODUCT", "VIEWMODEL_____: ${productResponse.value[0]!!.productName}")
        }
    }
    suspend fun getAllProductFromAPI(): List<ProductResponseItem> {
        return api.getAllProducts()
    }
}