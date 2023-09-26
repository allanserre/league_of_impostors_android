package com.example.league_of_impostors_android.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.league_of_impostors_android.models.Player
import com.example.league_of_impostors_android.repository.WebSocketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WebSocketViewModel(val webSocketRepository: WebSocketRepository = WebSocketRepository()) : ViewModel(){

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players : StateFlow<List<Player>>
        get() = _players.asStateFlow()

    private val _messages : MutableState<String> = mutableStateOf("")
    val messages : MutableState<String>
        get() = _messages
    init {
        viewModelScope.launch (Dispatchers.IO){
            webSocketRepository.webSocketEvent.collect { event ->
                when (event)  {
                    is WebSocketEvent.PlayerUpdate -> {
                        this@WebSocketViewModel._players.value = event.players
                    }
                    is WebSocketEvent.SocketUpdate -> {
                        println(event.event)
                        this@WebSocketViewModel._messages.value = event.event
                    }
                    is WebSocketEvent.ConnectionUpdate -> {

                    }
                }
            }
        }
    }
    fun connect(){
        webSocketRepository.startSocket()
    }

    fun createGame(username : String){
        webSocketRepository.setAuth(username)
        webSocketRepository.emitMessage("createRoom", username)
    }
}

sealed class WebSocketEvent {
    data class PlayerUpdate(val players : List<Player>) : WebSocketEvent()
    data class SocketUpdate(val event : String): WebSocketEvent()
    data class ConnectionUpdate(val event : String): WebSocketEvent()
}