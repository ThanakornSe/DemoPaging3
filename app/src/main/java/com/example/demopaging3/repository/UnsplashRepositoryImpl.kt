package com.example.demopaging3.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.demopaging3.api.UnsplashApi
import com.example.demopaging3.data.UnsplashPagingSource
import com.example.demopaging3.data.UnsplashPhoto

class UnsplashRepositoryImpl(private val unsplashApi: UnsplashApi) : UnsplashRepository {
    override fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
        ).liveData
}