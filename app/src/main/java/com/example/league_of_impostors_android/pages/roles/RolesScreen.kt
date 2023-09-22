package com.example.league_of_impostors_android.pages.roles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.league_of_impostors_android.R
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme

@Preview()
@Composable
fun RolesScreen() {
    LeagueOfImpostorsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.kayle_morg),
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
                Spacer(modifier = Modifier.height(20.dp))
                RolesList()
            }
        }
    }
}

@Composable
fun RolesList(rolesViewModel: RolesViewModel = RolesViewModel()) {
    val uiRoles = rolesViewModel.uiRoles

    LazyColumn(modifier = Modifier.fillMaxSize(),   verticalArrangement = Arrangement.spacedBy(40.dp), contentPadding = PaddingValues(20.dp)) {

        itemsIndexed(uiRoles) { index, role ->
            val even = index % 2 == 0
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = if (even) Alignment.Start else Alignment.End,

            ) {
                RoleCard(role = role)
            }
        }
    }
}


@Composable
fun RoleCard(role: Role) {
    ElevatedCard(
        modifier = Modifier
            .width(200.dp)
            .height(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        AsyncImage(
            model = role.image,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.logo_v1)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = role.description,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun RoleCardPreview() {
    RoleCard(role = Role("carte de démonstration", image = "https://dummyimage.com/100"))
}