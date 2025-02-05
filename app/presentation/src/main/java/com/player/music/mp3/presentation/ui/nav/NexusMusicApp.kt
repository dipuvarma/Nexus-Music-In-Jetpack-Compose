package com.player.music.mp3.presentation.ui.nav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.player.music.mp3.presentation.screens.pages.main.FavouriteScreen
import com.player.music.mp3.presentation.screens.pages.main.HomeScreen
import com.player.music.mp3.presentation.screens.pages.main.ProfileScreen
import com.player.music.mp3.presentation.screens.pages.main.SearchScreen
import com.player.music.mp3.presentation.screens.pages.other.MusicEqScreen
import com.player.music.mp3.presentation.screens.pages.other.MusicPlayerScreen
import com.player.music.mp3.presentation.screens.pages.other.SettingScreen
import com.player.music.mp3.presentation.screens.pages.other.playList.PlaylistScreen
import com.player.music.mp3.presentation.screens.pages.starter.InterestScreen
import com.player.music.mp3.presentation.screens.pages.starter.IntroScreen
import com.player.music.mp3.presentation.screens.pages.starter.PermissionScreen
import com.player.music.mp3.presentation.screens.pages.starter.SplashScreen
import com.player.music.mp3.presentation.screens.state.AppVM
import com.player.music.mp3.presentation.screens.state.MusicVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusMusicApp() {

    val context = LocalContext.current

    /*Shared ViewModel */
    val appViewModel = viewModel<AppVM>()
    val musicViewModel = viewModel<MusicVM>()

    /*Navigation Controller*/
    val navController = rememberNavController()

    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = currentBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            when (currentDestination) {
                Splash.route, Intro.route, Interest.route, Permission.route -> {
                    AnimatedVisibility(false) {
                        TopAppBar(title = { Text(text = "Nexus App") })
                    }
                }

                else -> null
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MusicPlayer,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Splash.route) {
                SplashScreen(
                    context = context
                )
            }

            composable(Intro.route) {
                IntroScreen(
                    viewModel = appViewModel,
                    context = context
                )
            }
            composable(Interest.route) {
                InterestScreen()
            }
            composable(Permission.route) {
                PermissionScreen(
                    context = context
                )
            }
            composable<Home> {
                HomeScreen()
            }
            composable<Search> {
                SearchScreen()
            }
            composable<Favourite> {
                FavouriteScreen()
            }
            composable<Profile> {
                ProfileScreen()
            }
            composable<Settings> {
                SettingScreen()
            }
            composable<Playlist> {
                PlaylistScreen()
            }
            composable<MusicPlayer> {
                MusicPlayerScreen(
                    context = context,
                    musicVM = musicViewModel
                )
            }
            composable<MusicEq> {
                MusicEqScreen()
            }
        }
    }
}