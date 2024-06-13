package com.example.medicaladminapp.Screens.Details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicaladminapp.API.RetrofitInstance
import com.example.medicaladminapp.DataModel.CreateProductResponse
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    val updateUserRes = mutableStateOf<CreateProductResponse?>(null)

    private suspend fun updateUserApproval(
        userId: String, approval: Int
    ): CreateProductResponse? {
        return RetrofitInstance.api.updateUserApprovals(userId = userId, approvedStatus = approval)
    }

    fun updateUserApprovalStatus(
        userId: String,
        approval:Int
    ) {
        viewModelScope.launch {
            updateUserRes.value =
                updateUserApproval(userId = userId, approval = approval)
        }
    }
    /*
        suspend fun updateUserBlocked(
            userId: String, approval: String
        ): CreateProductResponse? {
            return RetrofitInstance.api.user(userId = userId, approvedStatus = approval)
        }

        fun updateUserBlockedStatus(
            userId: String? = null,
            approval: String? = null
        ) {
            viewModelScope.launch {
                updateUserRes.value =
                    updateUserBlocked(userId = userId.toString(), approval = approval.toString())
            }
        }*/
}