package com.example.medicaladminapp.Screens.Vendors

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicaladminapp.API.RetrofitInstance
import com.example.medicaladminapp.DataModel.UserDataItem
import kotlinx.coroutines.launch

class VendorsViewModel:ViewModel() {
    val res = mutableStateOf<List<UserDataItem?>>(emptyList())

    var state = mutableStateOf<String?>(null)

    init {
        state.value = StateOrder.DEFAULT.state
        viewModelScope.launch {
            res.value = getAllUsers()
            Log.d("DATA", "VIEWMODEL_________: ${res.value[0]!!.name}")
        }
    }

    suspend fun getAllUsers(): List<UserDataItem?> {
        state.value = StateOrder.LOADING.state
        val result = RetrofitInstance.api.getAllUsers()
        if (result.isNotEmpty()) {
            state.value = StateOrder.SUCCESS.state
        } else {
            state.value = StateOrder.FAILED.state
        }
        return result
    }

    sealed class StateOrder(var state: String) {
        data object DEFAULT : StateOrder("default")
        data object FAILED : StateOrder("failed")
        data object SUCCESS : StateOrder("success")
        data object LOADING : StateOrder("loading")
    }
}