package com.aspiration.interview.data

import com.aspiration.interview.domain.PostEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostEntity(
    @SerializedName("userId") @Expose val userId: Long,
    @SerializedName("id") @Expose val id: Long,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("body") @Expose val body: String
){
    fun toDomain() = PostEntity(userId, id, title, body)
}