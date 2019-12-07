package com.akshaym.snipper

import com.google.gson.annotations.SerializedName


class RepositoriesResponse {
    @SerializedName("author")
    private val author: String? = null
    @SerializedName("name")
    private val name: String? = null
    @SerializedName("avatar")
    private val avatar: String? = null
    @SerializedName("url")
    private val url: String? = null
    @SerializedName("description")
    private val description: String? = null
    @SerializedName("language")
    private val language: String? = null
    @SerializedName("languageColor")
    private val languageColor: String? = null
    @SerializedName("stars")
    private val stars: Any? = null
    @SerializedName("forks")
    private val forks: Int? = null
    @SerializedName("currentPeriodStars")
    private val currentPeriodStars: Int? = null
    @SerializedName("builtBy")
    private val builtBy: List<BuiltBy>? = null
}

class BuiltBy {
    @SerializedName("username")
    private val username: String? = null
    @SerializedName("href")
    private val href: String? = null
    @SerializedName("avatar")
    private val avatar: String? = null
}

