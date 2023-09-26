package com.example.league_of_impostors_android

import androidx.lifecycle.ViewModel
import com.example.league_of_impostors_android.models.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Random
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class MainViewModel : ViewModel() {
    private var _uiPlayers: Flow<List<Player>> = flow {
        while (true) {
            val _uiPlayers = getPlayers()
            emit(_uiPlayers)
            delay(5000)
        }
    }
    val uiPlayer: Flow<List<Player>>
        get() = _uiPlayers

    private fun getPlayers(): List<Player> {
        return getDummyPlayers()
        // TODO: Récupérer la liste des roles via l'API firebase

    }

    private fun getDummyPlayers(): List<Player> {
        val roles = mutableListOf<Player>()
        for (i in 1..5) {
            val random = Random().nextInt(10)
            roles.add(Player("Pseudo n° $i $random"))
        }
        return roles
    }
}