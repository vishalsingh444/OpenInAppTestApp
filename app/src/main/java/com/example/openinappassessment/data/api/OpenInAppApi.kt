package com.example.openinappassessment.data.api

import com.example.openinappassessment.data.model.DataModel
import retrofit2.http.GET

interface OpenInAppApi {
    @GET("api/v1/dashboardNew")
    suspend fun fetchData(): DataModel
}