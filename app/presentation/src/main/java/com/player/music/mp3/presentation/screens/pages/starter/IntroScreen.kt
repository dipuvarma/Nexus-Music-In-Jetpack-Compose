package com.player.music.mp3.presentation.screens.pages.starter

import android.content.Context
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import com.player.music.mp3.presentation.screens.state.AppVM
import com.player.music.mp3.presentation.ui.component.SliderComp
import com.player.music.mp3.presentation.ui.nav.Interest
import com.player.music.mp3.presentation.ui.nav.Permission
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme
import kotlin.math.absoluteValue


@Composable
fun IntroScreen(
    viewModel: AppVM,
    context: Context,
    navController: NavController
) {
    val pagerState = rememberPagerState(
        pageCount = { viewModel.getIntroPagerData(context = context).size },
    )

    val lasIndex = rememberUpdatedState(viewModel.getIntroPagerData(context = context).lastIndex)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        // Pager for sliders
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f),
            contentPadding = PaddingValues(horizontal = 32.dp)
        ) { page ->
            val pageOffset =
                (pagerState.currentPage - page + pagerState.currentPageOffsetFraction).absoluteValue

            val data = viewModel.getIntroPagerData(context = context)[page]
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
                    image = data.image,
                    title = data.title,
                    description = data.description,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
        // Dots Indicator
        if (pagerState.currentPage == lasIndex.value) {
            AnimatedVisibility(true) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Permission.route) {
                                popUpTo(Permission.route) {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        } else {
            PagerIndicator(
                pageCount = viewModel.getIntroPagerData(context = context).size,
                currentPageIndex = pagerState.currentPage,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
private fun PagerIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
    Box() {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (currentPageIndex == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}