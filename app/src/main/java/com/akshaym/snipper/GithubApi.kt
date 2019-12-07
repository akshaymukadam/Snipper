package com.akshaym.snipper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("repositories")
    fun geTrendingRepo(
        @Query("language") language: String,
        @Query("since") timePeriod: String
    ): Call<List<RepositoriesResponse>>
}