package com.example.league_of_impostors_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.league_of_impostors_android.pages.home.HomeScreen
import com.example.league_of_impostors_android.pages.roles.RolesScreen
import com.example.league_of_impostors_android.ui.theme.LeagueOfImpostorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeagueOfImpostorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LeagueOfImpostorsApp()
                }
            }
        }
    }
}

@Composable
fun LeagueOfImpostorsApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        LeagueOfImpostorsNavHost(navController = navController)
    }
}

@Preview
@Composable
fun LeagueOfImpostorsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToGameLobby = { navController.navigate("friendsList") },
                onNavigateToHistory = { navController.navigate("friendsList") },
                onNavigateToRoles = { navController.navigate("roles") }
                /*...*/
            )
        }
        composable("roles") {
            RolesScreen()
        }
    }
}

@Preview
@Composable
private fun Greeting(name: String = "Allan Serre") {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}


@Composable
private fun DefaultPreview() {
    LeagueOfImpostorsTheme {
        LeagueOfImpostorsApp()
    }
}