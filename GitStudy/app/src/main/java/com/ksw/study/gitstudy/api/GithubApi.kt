package com.ksw.study.gitstudy.api

import com.ksw.study.gitstudy.model.GithubRepo
import com.ksw.study.gitstudy.model.GithubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{owner}")
    fun getUser(@Path("owner")owner: String) : Call<GithubUser>

    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner")owner: String) : Call<List<GithubRepo>>

}