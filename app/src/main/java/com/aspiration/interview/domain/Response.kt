package com.aspiration.interview.domain

sealed class Response <out T>{

    data class Success<out T>(val data: T) : Response<T>() {
        override fun succeeded(): Boolean {
            return true
        }
    }

    data class Fail(val exception: Throwable): Response<Nothing>()
    open fun succeeded(): Boolean {
        return false
    }
}
