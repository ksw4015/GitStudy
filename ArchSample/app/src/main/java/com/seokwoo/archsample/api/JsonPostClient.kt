package com.seokwoo.archsample.api

import com.seokwoo.archsample.model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Restful API 정의
 */
interface PostService {

    /**
     * get post by page number
     */
    @GET("posts")
    fun getPost(@Query("_page")page: Int): Call<List<Post>>

    /**
     * get initial page
     */
    @GET("posts?_page=1")
    fun getTopPost(): Call<List<Post>>

}


/**
 * Retrofit 객체 (싱글톤)
 */
private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
object JsonPostClient {

    private var postService: PostService? = null

    fun getPostService(): PostService {
        if(postService == null) {
            postService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostService::class.java
                )
        }
        return postService!!
    }

}