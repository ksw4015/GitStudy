package com.ksw.study.gitstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ksw.study.gitstudy.api.GithubClient
import com.ksw.study.gitstudy.model.GithubUser
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val LOG_TAG = "MainActivity::GitStudy"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = GithubClient.getGithubApi()

        btnSearch.setOnClickListener {
            val user = editUser.text.toString()
            Log.d(LOG_TAG, user)
            api.getUser(user).enqueue(object: Callback<GithubUser> {
                override fun onResponse(call: Call<GithubUser>, response: Response<GithubUser>) {
                    Log.d(LOG_TAG, response.body()?.name)
//                    val intent = Intent(applicationContext, ListActivity::class.java)
//                    intent.putExtra("user", response.body())
//                    startActivity(intent)
                }
                override fun onFailure(call: Call<GithubUser>, t: Throwable) {
                    Log.d(LOG_TAG, t.toString())
                }
            })
        }

    }

}
