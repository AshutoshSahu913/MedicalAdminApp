package com.example.medicaladminapp.API

import com.example.medicaladminapp.DataModel.CreateProductResponse
import com.example.medicaladminapp.DataModel.UserData
import com.example.medicalvendorapp.DataModel.ProductResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface ApiServices {

    @GET("/getAllUsers")
    suspend fun getAllUsers(): UserData

    @FormUrlEncoded
    @POST("/createProduct")
    suspend fun createProduct(
        @Field("Name") productName: String,
        @Field("Price") productPrice: String,
        @Field("Category") productCategory: String,
        @Field("Stock") productStock: String,
        @Field("IsActive") productCertified: String
    ): Response<CreateProductResponse>

    @FormUrlEncoded
    @PATCH("/updateUserApproval")
    suspend fun updateUserApprovals(
        @Field("userID") userId: String,
        @Field("approved") approvedStatus: Int,
    ): CreateProductResponse?

    @GET("/getAllProducts")
    suspend fun getAllProducts(): ProductResponse

    companion object {
        //        const val BASE_URL="http://127.0.0.1:5000"
        const val BASE_URL = "https://ashutoshsahu09.pythonanywhere.com"
    }
}