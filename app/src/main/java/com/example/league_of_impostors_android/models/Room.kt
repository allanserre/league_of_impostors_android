package com.example.league_of_impostors_android.models

enum class GameState {
    WAITING,
    INITIALIZED,
    STARTED,
    FINISHED,
}
class Room {
    val code : String = ""
    var state : GameState = GameState.WAITING
    var players : List<String> = emptyList()

    fun updatePlayers(players: List<String>){
        this.players = players
    }

    fun initializeGame(){
        this.state = GameState.INITIALIZED
    }

    fun startGame(){
        this.state = GameState.STARTED
    }
}