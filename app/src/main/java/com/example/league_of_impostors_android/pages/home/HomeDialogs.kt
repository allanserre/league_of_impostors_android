package com.example.league_of_impostors_android.pages.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.example.league_of_impostors_android.utils.AutoFocusTextField


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun JoinGameDialog(onDismissRequest : () -> Unit = {}, onConfirmation : () -> Unit = {}){

    var lobby_id by remember {
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
                    placeholder = { Text(text = "Pseudo" ) }
                )
                TextField(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    placeholder = { Text(text = "ID") },
                    onValueChange = { lobby_id = it },
                    value = lobby_id
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Annuler")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Rejoindre")
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CreateGameDialog(onDismissRequest : () -> Unit = {}, onConfirmation : () -> Unit = {}){
    var text by remember {
        mutableStateOf("")
    }


    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card (shape = RoundedCornerShape(16.dp)){
            Column {
                AutoFocusTextField(
                    modifier = Modifier
                        .padding(20.dp),
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text(text = "Pseudo" ) }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Annuler")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Créer")
                    }
                }
            }

        }
    }
}