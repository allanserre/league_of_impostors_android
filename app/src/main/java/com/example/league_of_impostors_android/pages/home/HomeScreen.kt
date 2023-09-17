package com.example.league_of_impostors_android.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.league_of_impostors_android.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun HomeScreen(
    onNavigateToGameLobby: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToRoles: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.jhin_camille),
            contentDescription = "fond d'écran page principale",
            contentScale = ContentScale.FillHeight
        )
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.logo_v1),
                contentDescription = "Titre de l'application",
                alignment = Alignment.Center
            )
            ActionButtons(
                onNavigateToHistory = onNavigateToHistory,
                onNavigateToRoles = onNavigateToRoles,
                onNavigateToGameLobby = onNavigateToGameLobby
            )
        }
    }
}

@Composable
fun ActionButtons(
    onNavigateToGameLobby: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToRoles: () -> Unit = {}
) {

    val openCreateGameDialog = remember {
        mutableStateOf(false)
    }
    val openJoinGameDialog = remember {
        mutableStateOf(false)
    }

    when {
        openCreateGameDialog.value -> {
            CreateGameDialog(
                onDismissRequest = { openCreateGameDialog.value = false }
            )
        }

        openJoinGameDialog.value -> {
            JoinGameDialog(
                onDismissRequest = { openJoinGameDialog.value = false }
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HomeButton(onClick = { openCreateGameDialog.value = true }, text = "Créer Partie")
        HomeButton(onClick = { openJoinGameDialog.value = true }, text = "Rejoindre Partie")
        HomeButton(onClick = { onNavigateToRoles() }, text = "Rôles")
        HomeButton(onClick = { onNavigateToHistory() }, text = "Historique")
    }
}

@Composable
fun HomeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    ElevatedButton(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}
