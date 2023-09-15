package com.example.league_of_impostors_android.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.league_of_impostors_android.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun HomeScreen(onNavigateToGameLobby : () -> Unit = {},
               onNavigateToHistory : () -> Unit = {},
               onNavigateToRoles : () -> Unit = {}){
    Surface (modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.jhin_camille), contentDescription = "fond d'écran page principale", contentScale = ContentScale.FillHeight)
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = R.drawable.logo_v1), contentDescription = "Titre de l'application", alignment = Alignment.Center)
            ActionButtons(
                onNavigateToHistory = onNavigateToHistory,
                onNavigateToRoles = onNavigateToRoles,
                onNavigateToGameLobby = onNavigateToGameLobby)
        }
    }
}

@Composable
fun ActionButtons(onNavigateToGameLobby : () -> Unit = {},
                  onNavigateToHistory : () -> Unit = {},
                  onNavigateToRoles : () -> Unit = {}){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        HomeButton(onClick = { /*TODO*/ }, text = "Créer Partie")
        HomeButton(onClick = { /*TODO*/ }, text = "Rejoindre Partie")
        HomeButton(onClick = { onNavigateToRoles }, text = "Rôles")
        HomeButton(onClick = { onNavigateToHistory }, text = "Historique")
    }
}

@Composable
fun HomeButton(modifier: Modifier = Modifier,
               onClick: () -> Unit,
               text : String){
    ElevatedButton(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

@Composable
fun CreateGameDialog(){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        
    }
}