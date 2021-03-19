package com.aspiration.interview.data.network.service

import com.aspiration.interview.data.PostEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Observable<List<PostEntity>>
}