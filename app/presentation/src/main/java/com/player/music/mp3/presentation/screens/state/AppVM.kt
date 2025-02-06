package com.player.music.mp3.presentation.screens.state

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.screens.state.model.IntroPagerModel
import com.player.music.mp3.presentation.screens.state.model.MusicCategory
import com.player.music.mp3.presentation.ui.component.bottom.BottomItem
import com.player.music.mp3.presentation.ui.nav.Favourite
import com.player.music.mp3.presentation.ui.nav.Home
import com.player.music.mp3.presentation.ui.nav.Profile
import com.player.music.mp3.presentation.ui.nav.Search


class AppVM : ViewModel() {

    fun getIntroPagerData(context: Context): List<IntroPagerModel> {
        return listOf(
            IntroPagerModel(
                image = R.drawable.placeholder_news,
                title = context.getString(R.string.title_1),
                description = context.getString(R.string.description_1)
            ),

            IntroPagerModel(
                image = R.drawable.loading_image,
                title = context.getString(R.string.title_2),
                description = context.getString(R.string.description_2)
            ),

            IntroPagerModel(
                image = R.drawable.pattern_bg,
                title = context.getString(R.string.title_3),
                description = context.getString(R.string.description_3)
            ),

            IntroPagerModel(
                image = R.drawable.loading_image,
                title = context.getString(R.string.title_4),
                description = context.getString(R.string.description_4)
            ),
        )

    }

    fun getMusicCategories(): List<MusicCategory> {
        return listOf(
            MusicCategory(name = "Pop", R.drawable.ic_launcher_background),
            MusicCategory(name = "Rock", image = R.drawable.placeholder_news),
            MusicCategory(name = "Jazz", image = R.drawable.placeholder_news),
            MusicCategory(name = "Classical", image = R.drawable.placeholder_news),
            MusicCategory(name = "Hip Hop", image = R.drawable.placeholder_news),
            MusicCategory(name = "Electronic", image = R.drawable.placeholder_news),
            MusicCategory(name = "Reggae", image = R.drawable.placeholder_news),
            MusicCategory(name = "Blues", image = R.drawable.placeholder_news),
            MusicCategory(name = "Country", image = R.drawable.placeholder_news),
            MusicCategory(name = "Metal", image = R.drawable.placeholder_news),
            MusicCategory(name = "Folk", image = R.drawable.placeholder_news),
            MusicCategory(name = "R&B", image = R.drawable.placeholder_news),
            MusicCategory(name = "Soul", image = R.drawable.placeholder_news),
            MusicCategory(name = "Punk", image = R.drawable.placeholder_news),
            MusicCategory(name = "Indie", image = R.drawable.placeholder_news)
        )
    }

    val gradientList = listOf(
        listOf(Color(0xFFFF5733), Color(0xFFFFC300)), // Orange to Yellow
        listOf(Color(0xFF8E44AD), Color(0xFF3498DB)), // Purple to Blue
        listOf(Color(0xFF1ABC9C), Color(0xFF16A085)), // Greenish tones
        listOf(Color(0xFFD35400), Color(0xFFC0392B)), // Reddish orange
        listOf(Color(0xFF2ECC71), Color(0xFF27AE60)), // Green shades
        listOf(Color(0xFF2980B9), Color(0xFF6DD5FA)), // Light Blue gradient
        listOf(Color(0xFFEC407A), Color(0xFFAB47BC)), // Pink to Purple
        listOf(Color(0xFFEF5350), Color(0xFFFFA726)), // Red to Orange
        listOf(Color(0xFF42A5F5), Color(0xFF26C6DA)), // Blue to Teal
        listOf(Color(0xFFFFD54F), Color(0xFFFFA726))  // Yellow to Orange
    )

    var bottomItemList = listOf(
        BottomItem(
            name = "Home",
            route = Home.route,
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home
        ),
        BottomItem(
            name = "Search",
            route = Search.route,
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search
        ),
        BottomItem(
            name = "Favourite",
            route = Favourite.route,
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Outlined.FavoriteBorder
        ),
        BottomItem(
            name = "Profile",
            route = Profile.route,
            selectedIcon = Icons.Filled.Person,
            unSelectedIcon = Icons.Outlined.Person
        )
    )

}