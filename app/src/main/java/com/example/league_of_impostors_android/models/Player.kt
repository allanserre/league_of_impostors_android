package com.example.league_of_impostors_android.models

enum class Role {
    IMPOSTOR,
    LEADER,
    DICTATOR
}
data class Player (
    val username : String = "",
    val role : Role = Role.IMPOSTOR
)