package com.example.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetail(
    @SerializedName("name") val name: String = "VACIO",
    @SerializedName("powerstats") val powerStats: PowerStats = PowerStats(),
    @SerializedName("image") val image: ImageHeroe = ImageHeroe()
)

data class PowerStats(
    @SerializedName("intelligence") val intelligence: String = "VACIO",
    @SerializedName("strength") val strength: String  = "VACIO",
    @SerializedName("speed") val speed: String  = "VACIO",
    @SerializedName("durability") val durability: String  = "VACIO",
    @SerializedName("power") val power: String  = "VACIO",
    @SerializedName("combat") val combat: String  = "VACIO"
)
