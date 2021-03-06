package com.aspiration.interview.presentation.base

interface BasePresenter<in V : BaseView> {
    fun bindView(view: V)
    fun unbindView()
}