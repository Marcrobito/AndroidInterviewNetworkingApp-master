package com.aspiration.interview.domain

import android.util.Log
import com.aspiration.interview.domain.repository.InterviewTaskRepositoryInterface
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

private const val TAG = "InterviewTaskUseCase"
class InterviewTaskUseCase(
    private val ioScheduler: Scheduler,
    private val repository: InterviewTaskRepositoryInterface
) :
    InterviewTaskUseCaseInterface {
            override fun invoke(): Observable<Response<List<PostEntity>>> = repository.getPosts()
                .subscribeOn(ioScheduler).doOnError {
                    Log.d(TAG, "Error")
                }.onErrorReturn {
                    listOf()
                }.flatMap {
                    if (it.isNotEmpty()){
                        Log.d(TAG, "Success")
                        Observable.just(
                            Response.Success(it.map { post -> post.toDomain() })
                        )
                    }
                    else
                        Observable.just(Response.Fail(Exception("error")))
                }

                    // TODO mandatory: use usecase as a proxy for your data and just return what came from server
                    // TODO mandatory: write logs that represents success/error state
                    // TODO optional: add header after each item. For more details, look into Readme file

}