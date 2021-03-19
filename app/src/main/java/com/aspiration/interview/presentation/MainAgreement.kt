package com.aspiration.interview.presentation

import com.aspiration.interview.domain.PostEntity
import com.aspiration.interview.presentation.base.BasePresenter
import com.aspiration.interview.presentation.base.BaseView

interface MainAgreement {
    interface View : BaseView {
        fun dataLoaded(data: List<PostEntity>)
        fun dataFail(error: String)
    }

    interface Presenter : BasePresenter<View> {
        // TODO set API request (usecase) methods invocation
        fun fetchButtonWasClicked()
    }
}