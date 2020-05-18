package com.ksw.study.gitstudy.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class GithubRepo(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("created_at")
    val created: String
)

@Parcelize
data class GithubUser(
    @SerializedName("login")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("location")
    var location: String?,
    @SerializedName("company")
    var company: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("bio")
    var bio: String?
): Parcelable