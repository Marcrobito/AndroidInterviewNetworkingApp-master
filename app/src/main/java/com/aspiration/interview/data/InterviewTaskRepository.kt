package com.aspiration.interview.data

import com.aspiration.interview.data.network.service.ApiService
import com.aspiration.interview.domain.repository.InterviewTaskRepositoryInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class InterviewTaskRepository(private val api: ApiService): InterviewTaskRepositoryInterface {
    override fun getPosts(): Observable<List<PostEntity>> {
        return api.getPosts().observeOn(AndroidSchedulers.mainThread())
    }
}