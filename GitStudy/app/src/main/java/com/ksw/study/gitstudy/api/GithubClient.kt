package com.ksw.study.gitstudy.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com"

object GithubClient {

    private var githubApi: GithubApi? = null

    fun getGithubApi(): GithubApi {
        if(githubApi == null) {
            githubApi = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApi::class.java)
        }
        return githubApi!!
    }

}