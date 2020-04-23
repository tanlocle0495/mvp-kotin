package com.tanloc.le.myapplication.network.model.blog

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Blog(
    @SerializedName("blog_url")
    var blogUrl: String? = null,

    @Expose
    @SerializedName("img_url")
    var coverImgUrl: String? = null,

    @Expose
    @SerializedName("title")
    var title: String? = null,

    @Expose
    @SerializedName("description")
    var description: String? = null,

    @Expose
    @SerializedName("author")
    var author: String? = null,

    @Expose
    @SerializedName("published_at")
    var date: String? = null
)
