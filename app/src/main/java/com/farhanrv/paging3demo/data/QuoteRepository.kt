package com.farhanrv.paging3demo.data

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.farhanrv.paging3demo.database.QuoteDatabase
import com.farhanrv.paging3demo.network.ApiService
import com.farhanrv.paging3demo.network.QuoteResponseItem

class QuoteRepository(private val quoteDatabase: QuoteDatabase, private val apiService: ApiService) {
    @OptIn(ExperimentalPagingApi::class)
    fun getQuote(): LiveData<PagingData<QuoteResponseItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = QuoteRemoteMediator(quoteDatabase, apiService),
            pagingSourceFactory = {
//                QuotePagingSource(apiService)
                quoteDatabase.quoteDao().getAllQuote()
            }
        ).liveData
    }
}