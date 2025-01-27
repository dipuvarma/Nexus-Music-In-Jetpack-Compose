package com.player.music.mp3.presentation.screens.pages.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.player.music.mp3.presentation.ui.component.SliderComp
import kotlin.math.absoluteValue


@Composable
fun IntroScreen(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(
        pageCount = { sliderItems.size },
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        // Pager for sliders
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 32.dp)
        ) { page ->

            val pageOffset =
                (pagerState.currentPage - page + pagerState.currentPageOffsetFraction).absoluteValue

            Box(
                modifier = Modifier
                    .graphicsLayer {
                        // Scale effect based on the page offset
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        // Slight alpha effect for smooth transitions
                        alpha = lerp(
                            start = 0.6f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .fillMaxSize()
            ) {

                SliderComp(
                    image = sliderItems[page].image,
                    title = sliderItems[page].title,
                    description = sliderItems[page].description,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
        // Dots Indicator
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            sliderItems.forEachIndexed { index, _ ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(if (isSelected) 12.dp else 8.dp)
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(50))
                        .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray)
                )
            }
        }
    }
}