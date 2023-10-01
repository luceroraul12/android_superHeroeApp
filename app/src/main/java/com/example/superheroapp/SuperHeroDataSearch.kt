package com.example.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataSearch(
    @SerializedName("response") val reponse: String = "VACIO",
    @SerializedName("results") val superHeroResults: List<SuperHeroResult> = emptyList()
)

data class SuperHeroResult(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: ImageHeroe
)

data class ImageHeroe(
    @SerializedName("url") val url: String = "VACIO"
)
