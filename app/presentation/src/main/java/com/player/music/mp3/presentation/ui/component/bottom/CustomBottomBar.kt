package com.player.music.mp3.presentation.ui.component.bottom

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.player.music.mp3.presentation.screens.state.AppVM
import com.player.music.mp3.presentation.ui.nav.Home

@Composable
fun CustomBottomBar(
    currentDestination: String?,
    appViewModel: AppVM,
    navController: NavController,
) {
    BottomAppBar {
        appViewModel.bottomItemList.forEach { bottomItem ->
            NavigationBarItem(
                selected = currentDestination == bottomItem.route,
                onClick = {
                    navController.navigate(bottomItem.route) {
                        popUpTo(Home.route) {
                            saveState = true
                        }
                    }
                },
                label = { Text(text = bottomItem.name) },
                icon = {
                    if (currentDestination == bottomItem.route) {
                        Icon(
                            imageVector = bottomItem.selectedIcon,
                            contentDescription = bottomItem.name
                        )
                    } else {
                        Icon(
                            imageVector = bottomItem.unSelectedIcon,
                            contentDescription = bottomItem.name
                        )
                    }
                }
            )
        }
    }
}