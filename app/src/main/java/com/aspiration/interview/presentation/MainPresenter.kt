package com.aspiration.interview.presentation

import android.util.Log
import com.aspiration.interview.domain.InterviewTaskUseCaseInterface
import com.aspiration.interview.domain.Response
import com.aspiration.interview.presentation.base.BasePresenterImpl
import javax.inject.Inject

class MainPresenter @Inject constructor(private val useCase: InterviewTaskUseCaseInterface) :
    BasePresenterImpl<MainAgreement.View>(), MainAgreement.Presenter {


    override fun fetchButtonWasClicked() {
        Log.d("TAG", "fetchButtonWasClicked")
        view?.let {
            it.showLoading()
            useCase.invoke().subscribe{ response ->
                it.hideLoading()
                if (response is Response.Success){
                    it.dataLoaded(response.data)
                    return@subscribe
                }

                it.dataFail("Data was unavailable")
            }
        }

    }


}