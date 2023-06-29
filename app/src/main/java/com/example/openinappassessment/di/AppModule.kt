package com.example.openinappassessment.di

import com.example.openinappassessment.data.api.AuthInterceptor
import com.example.openinappassessment.data.api.OpenInAppApi
import com.example.openinappassessment.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideAPIService(): OpenInAppApi{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(Constants.token))
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(OpenInAppApi::class.java)
    }


}