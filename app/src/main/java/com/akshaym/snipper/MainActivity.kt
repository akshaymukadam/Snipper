package com.akshaym.snipper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://github-trending-api.now.sh/"

class MainActivity : AppCompatActivity() {

    lateinit var githubApi: GithubApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val configuration =
            Configuration.Builder(this).addInterceptor(listOf(HttpLoggingInterceptor()))
                .surveillance(true).tamper(true).build()
        val client = SniperClient.create(configuration)


        githubApi = Retrofit.Builder().client(client).baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GithubApi::class.java)

        githubApi.geTrendingRepo("kotlin", "month")
            .enqueue(object : Callback<List<RepositoriesResponse>> {
                override fun onFailure(call: Call<List<RepositoriesResponse>>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<List<RepositoriesResponse>>,
                    response: Response<List<RepositoriesResponse>>?
                ) {
                    response?.let {
                        Log.e("onResponse", "${it.body()}")
                    }

                }

            })
    }

}

