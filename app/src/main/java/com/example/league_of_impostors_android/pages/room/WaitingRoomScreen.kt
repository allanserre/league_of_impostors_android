package com.example.league_of_impostors_android.pages.room

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.league_of_impostors_android.MainViewModel
import com.example.league_of_impostors_android.R
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme

data class PlayerInfo(val name: String)

@Composable
@Preview
fun WaitingRoomScreen() {
    LeagueOfImpostorsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.jhin_camille),
                contentDescription = "fond d'écran page historique",
                contentScale = ContentScale.FillHeight
            )
            PlayerList()
        }
    }
}

@Composable
fun PlayerList(mainViewModel: MainViewModel = MainViewModel()){
    val players by mainViewModel.uiPlayer.collectAsState(initial = emptyList())
    LazyColumn(contentPadding = PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(5) { index ->
            PlayerCardHolder(index, players)
        }
    }
}

@Composable
fun PlayerCardHolder(index : Int, players : List<PlayerInfo>){
    if (players.size <= index){
        BlankPlayerCard()
    }else {
        AnimatedPlayerCard(player = players[index])
    }
}
@Preview
@Composable
fun BlankPlayerCard() {
    PlayerCard(name = "Vide", link = "https://dummyimage.com/300", scale = 1f )
}

@Composable
fun AnimatedPlayerCard(player: PlayerInfo) {
    var startAnimation by remember { mutableStateOf(false) }

    val scale: Float by animateFloatAsState(if (startAnimation) 1f else 0.9f, animationSpec = spring(dampingRatio = 0.5f, stiffness = Spring.StiffnessLow),
        label = "playerCard_animation"
    )

    LaunchedEffect(key1 = true ){
        startAnimation = true
    }

    PlayerCard(name = player.name , link = "https://dummyimage.com/300", scale = scale)
}

@Composable
fun PlayerCard(name : String, link : String, scale: Float){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .scale(scale),
        shape = RoundedCornerShape(
            topStartPercent = 50,
            bottomStartPercent = 50,
            bottomEndPercent = 10,
            topEndPercent = 10
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = link,
                contentDescription = "Pseudo",
                placeholder = painterResource(
                    id = R.drawable.ic_launcher_background
                ),
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = name, textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Preview
@Composable
fun PlayerCardPreview() {
    LeagueOfImpostorsTheme {
        AnimatedPlayerCard(player = PlayerInfo("PseudoDefault"))
    }
}