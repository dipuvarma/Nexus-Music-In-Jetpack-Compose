package com.player.music.mp3.presentation.screens.state

import android.content.Context
import androidx.lifecycle.ViewModel
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.screens.state.model.IntroPagerModel


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

}