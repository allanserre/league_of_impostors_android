package com.example.league_of_impostors_android.pages.roles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.league_of_impostors_android.R
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme

@Preview()
@Composable
fun RolesScreen(){
    LeagueOfImpostorsTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.kayle_morg), contentDescription = "fond d'écran page principale", contentScale = ContentScale.FillHeight)
            Column {
                Spacer(modifier = Modifier.height(40.dp))
                Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = R.drawable.logo_v1), contentDescription = "Titre de l'application", alignment = Alignment.Center)
                Spacer(modifier = Modifier.height(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    )) {

                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .width(200.dp)
                            .height(150.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                    }
                }
            }
        }
    }
}

@Composable
fun RolesList(rolesViewModel: RolesViewModel = RolesViewModel()){
    val uiRoles = rolesViewModel.uiRoles

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        items(uiRoles){ role -> {

        }

        }
    }
}

@Composable
fun RoleCard(role : Role) {
    ElevatedCard(
        modifier = Modifier
            .padding(20.dp)
            .width(200.dp)
            .height(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        AsyncImage(painter = Painter., contentDescription = )
        Text(text = role.description)
    }
}