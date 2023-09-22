package com.example.league_of_impostors_android.pages.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.league_of_impostors_android.R
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme


data class GameResult(val win : Boolean, val score : Int)
@Preview
@Composable
fun HistoryScreen() {
    LeagueOfImpostorsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.xayah_rakkan),
                contentDescription = "fond d'écran page historique",
                contentScale = ContentScale.FillHeight
            )
            GameHistoryList()
        }
    }
}

@Composable
fun GameHistoryList(historyViewModel: HistoryViewModel = HistoryViewModel()){
    // TODO: Get games from viewmodel
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(8) {game ->
            GameCard(GameResult(true,32))
        }
    }
}


@Composable
fun GameCard(result : GameResult ){
    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = if (result.win) "Victoire" else "Défaite" )
            Text(text = "Score : ${result.score}" )
        }
    }
}

@Preview
@Composable
fun GameCardPreview(){
    LeagueOfImpostorsTheme {
        GameCard(GameResult(true,32))
    }
}