package com.aspiration.interview.domain.repository

import com.aspiration.interview.data.PostEntity
import com.aspiration.interview.domain.Response
import io.reactivex.Observable

interface InterviewTaskRepositoryInterface {
    fun getPosts(): Observable<List<PostEntity>>
}