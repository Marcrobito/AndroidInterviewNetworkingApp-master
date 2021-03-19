package com.aspiration.interview.domain

import io.reactivex.Observable

interface InterviewTaskUseCaseInterface {
    fun invoke(): Observable<Response<List<PostEntity>>>

    // TODO add your interface method for implementation here


    // TODO mandatory: use usecase as a proxy for your data and just return what came from server
    // TODO mandatory: write logs that represents success/error state
    // TODO optional: add header after each item. For more details, look into Readme file
}