package com.farhanrv.paging3demo.di

import android.content.Context
import com.farhanrv.paging3demo.data.QuoteRepository
import com.farhanrv.paging3demo.database.QuoteDatabase
import com.farhanrv.paging3demo.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val database = QuoteDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(database, apiService)
    }
}