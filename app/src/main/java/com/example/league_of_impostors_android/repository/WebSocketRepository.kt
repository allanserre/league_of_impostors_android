package com.example.league_of_impostors_android.repository

import com.example.league_of_impostors_android.models.Player
import com.example.league_of_impostors_android.viewmodel.WebSocketEvent
import com.google.gson.Gson
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.engineio.client.transports.WebSocket
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Singleton
class WebSocketRepository{

    private val webSocketEventChannel = Channel<WebSocketEvent> {  }
    val webSocketEvent = webSocketEventChannel.receiveAsFlow()

    fun startSocket(){
        this.socket.connect()
    }

    fun setAuth(username : String){
        this.options.auth["username"] = username
    }
    fun stopSocket(){
        this.socket.disconnect()
    }

    fun emitMessage(event : String, msg : String){
        socket.emit(event,msg)
    }

    private val options: IO.Options = IO.Options.builder().setTransports(arrayOf(WebSocket.NAME)).setAuth(
        mutableMapOf()
    ) .build()
    private val socket : Socket = IO.socket("https://league-of-impostors-jrxhcy7lxa-ey.a.run.app",options)

    fun displayAll(array : Array<Any>){
        array.forEach {
            print(it)
        }
    }
    constructor(){
        socket.on(Socket.EVENT_CONNECT) {
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.ConnectionUpdate("connect"))
                println("connect")
            }
        }

        socket.on(Socket.EVENT_DISCONNECT) {
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.ConnectionUpdate("disconnect"))
                println("disconnect")
            }
        }

        socket.on(Socket.EVENT_CONNECT_ERROR) {
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.ConnectionUpdate("error $it"))
                displayAll(it)
                println("error $it")
            }
        }

        socket.on("reconnect") {
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.ConnectionUpdate("reconnect"))
                println("reconnect")
            }
        }

        socket.on("reconnect_attempt") {
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.ConnectionUpdate("reconnect attempt $it"))
                displayAll(it)
                println("reconnect attempt $it")
            }
        }

        listOf(
            "createRoomFailed",
            "createRoomSuccess",
            "joinRoomFailed",
            "joinRoomSuccess",
            "startGame"
        ).forEach { event ->
            socket.on(event) { data ->
                GlobalScope.launch {
                    webSocketEventChannel.send(WebSocketEvent.SocketUpdate(event))
                }
                println(event)
            }
        }

        socket.on("updatePlayers"){data ->
            val gson = Gson()
            val players : List<Player> = gson.fromJson(data[0].toString(), Array<Player>::class.java).toList()
            GlobalScope.launch {
                webSocketEventChannel.send(WebSocketEvent.PlayerUpdate(players))
            }
        }

    }
}
