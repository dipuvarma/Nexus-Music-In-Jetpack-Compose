package com.player.music.mp3.presentation.screens.pages.starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.player.music.mp3.presentation.screens.state.AppVM
import com.player.music.mp3.presentation.ui.nav.Home


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterestScreen(
    appVM: AppVM,
    navController: NavController
) {

    val gradientList = appVM.gradientList
    val interestList = remember { mutableStateListOf(*appVM.getMusicCategories().toTypedArray()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        FlowRow {
            interestList.forEachIndexed { index, interest ->
                val gradientColors = remember { gradientList.random() }
                CustomChip(
                    text = interest.name,
                    isSelected = interest.isSelected,
                    color = gradientColors,
                    backgroundImage = interest.image,
                    onClick = {
                        interestList[index] = interest.copy(isSelected = !interest.isSelected)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Home) }
        ) {
            Text(text = "Continue")
        }
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
private fun CustomChip(
    text: String,
    isSelected: Boolean,
    color: List<Color>,
    backgroundImage: Int,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        Brush.verticalGradient(color)
    } else {
        Brush.verticalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }
    Surface(
        modifier = Modifier
            .width(100.dp)
            .height(48.dp)
            .padding(4.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        color = Color.Transparent // Ensure color comes from background
    ) {
        Box {
            if (isSelected) {
                Image(
                    painter = painterResource(id = backgroundImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.8f)
                    .background(
                        brush = backgroundColor,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


