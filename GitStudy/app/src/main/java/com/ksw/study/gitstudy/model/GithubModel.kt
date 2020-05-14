package com.ksw.study.gitstudy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class GithubRepo(
    val name: String,
    val desc: String,
    val created: String
)

@Parcelize
data class GithubUser(
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("bio")
    val bio: String
): Parcelable