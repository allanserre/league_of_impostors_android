package com.example.league_of_impostors_android.pages.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme
import com.example.league_of_impostors_android.utils.AutoFocusTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinGameDialog(
    onDismissRequest: () -> Unit = {},
    onConfirmation: (String,String) -> Unit,
    isLoading : Boolean) {

    var lobbyId by remember {
        mutableStateOf("")
    }

    var pseudo by remember {
        mutableStateOf("")
    }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column {
                AutoFocusTextField(
                    modifier = Modifier
                        .padding(20.dp),
                    value = pseudo,
                    onValueChange = { pseudo = it },
                    placeholder = { Text(text = "Pseudo") }
                )
                TextField(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    placeholder = { Text(text = "ID") },
                    onValueChange = { lobbyId = it },
                    value = lobbyId
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    if ( !isLoading ){
                        TextButton(
                            onClick = { onDismissRequest() },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Annuler")
                        }
                        TextButton(
                            onClick = { onConfirmation(lobbyId,pseudo) },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Rejoindre")
                        }
                    }
                    else {
                        CircularProgressIndicator()
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateGameDialog(
    onDismissRequest: () -> Unit = {},
    onConfirmation: (String) -> Unit,
    isLoading : Boolean
)
{

    var username by remember {
        mutableStateOf("")
    }


    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column {
                AutoFocusTextField(
                    modifier = Modifier
                        .padding(20.dp),
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text(text = "Pseudo") }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    if ( !isLoading ){
                        TextButton(
                            onClick = { onDismissRequest() },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Annuler")
                        }
                        TextButton(
                            onClick = { onConfirmation(username) },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Créer")
                        }
                    } else {
                        CircularProgressIndicator()
                    }

                }
            }

        }
    }
}

@Preview
@Composable
fun CreateGameDialogPreview(){
    LeagueOfImpostorsTheme {
        CreateGameDialog(onConfirmation = { s1 : String -> {} } , onDismissRequest = {} , isLoading = true)
    }
}

@Preview
@Composable
fun JoinGameDialogPreview(){
    LeagueOfImpostorsTheme {
        JoinGameDialog(onConfirmation = { s1 : String,s2 : String -> {} } , onDismissRequest = {}, isLoading = false)
    }
}