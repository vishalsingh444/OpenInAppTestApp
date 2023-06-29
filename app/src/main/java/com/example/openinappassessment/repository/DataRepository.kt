package com.example.openinappassessment.repository

import com.example.openinappassessment.data.api.OpenInAppApi
import com.example.openinappassessment.data.model.DataModel
import javax.inject.Inject

interface DataRepository {
    suspend fun getData(): DataModel
}

class NetworkDataRepository @Inject constructor(
    private val openInAppApi: OpenInAppApi
): DataRepository{
    override suspend fun getData(): DataModel {
        return openInAppApi.fetchData()
    }
}