package com.example.demopaging3.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.demopaging3.data.UnsplashPhoto


interface UnsplashRepository {
    fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>>
}