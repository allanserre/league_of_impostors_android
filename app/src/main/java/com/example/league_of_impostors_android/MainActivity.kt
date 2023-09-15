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
import com.example.league_of_impostors_android.pages.HomeScreen
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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun LeagueOfImpostors(modifier: Modifier = Modifier){
    Surface (
        modifier = modifier,
        color    = MaterialTheme.colorScheme.background
    ){
        Greeting("Android")
    }
}

@Composable
fun LeagueOfImpostorsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "profile"
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToGameLobby = { navController.navigate("friendsList") },
                onNavigateToHistory = { navController.navigate("friendsList") },
                onNavigateToRoles = { navController.navigate("friendsList") }
                /*...*/
            )
        }
        composable("history") {  }
    }
}
@Composable
private fun Greeting(name: String) {
    Surface(color = MaterialTheme.colorScheme.primary
    ) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    LeagueOfImpostorsTheme {
        LeagueOfImpostors()
    }
}