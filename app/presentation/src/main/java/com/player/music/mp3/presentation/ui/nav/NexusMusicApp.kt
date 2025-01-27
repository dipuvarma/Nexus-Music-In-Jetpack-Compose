package com.player.music.mp3.presentation.ui.nav

import androidx.compose.animation.core.snap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.player.music.mp3.presentation.screens.pages.FavouriteScreen
import com.player.music.mp3.presentation.screens.pages.HomeScreen
import com.player.music.mp3.presentation.screens.pages.InterestScreen
import com.player.music.mp3.presentation.screens.pages.MusicEqScreen
import com.player.music.mp3.presentation.screens.pages.MusicPlayerScreen
import com.player.music.mp3.presentation.screens.pages.PermissionScreen
import com.player.music.mp3.presentation.screens.pages.ProfileScreen
import com.player.music.mp3.presentation.screens.pages.SearchScreen
import com.player.music.mp3.presentation.screens.pages.SettingScreen
import com.player.music.mp3.presentation.screens.pages.intro.IntroScreen
import com.player.music.mp3.presentation.screens.pages.playList.PlaylistScreen
import com.player.music.mp3.presentation.screens.pages.splash.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusMusicApp() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
        bottomBar = {},
        snackbarHost = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Intro,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Splash> {
                SplashScreen()
            }
            composable<Intro> {
                IntroScreen()
            }
            composable<Interest> {
                InterestScreen()
            }
            composable<Permission> {
                PermissionScreen()
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
                MusicPlayerScreen()
            }
            composable<MusicEq> {
                MusicEqScreen()
            }
        }
    }
}