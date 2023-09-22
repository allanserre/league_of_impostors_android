package com.example.league_of_impostors_android

import androidx.lifecycle.ViewModel
import com.example.league_of_impostors_android.pages.room.PlayerInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Random
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class MainViewModel : ViewModel() {
    private var _uiPlayers: Flow<List<PlayerInfo>> = flow {
        while (true) {
            val _uiPlayers = getPlayerInfos()
            emit(_uiPlayers)
            delay(5000)
        }
    }
    val uiPlayer: Flow<List<PlayerInfo>>
        get() = _uiPlayers

    private fun getPlayerInfos(): List<PlayerInfo> {
        return getDummyPlayerInfos()
        // TODO: Récupérer la liste des roles via l'API firebase

    }

    private fun getDummyPlayerInfos(): List<PlayerInfo> {
        val roles = mutableListOf<PlayerInfo>()
        for (i in 1..5) {
            val random = Random().nextInt(10)
            roles.add(PlayerInfo("Pseudo n° $i $random"))
        }
        return roles
    }
}