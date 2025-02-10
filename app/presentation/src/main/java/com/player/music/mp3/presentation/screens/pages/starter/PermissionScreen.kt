package com.player.music.mp3.presentation.screens.pages.starter

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.component.PermissionComp
import com.player.music.mp3.presentation.ui.nav.Interest

@Composable
fun PermissionScreen(
    context: Context,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = context.getString(R.string.permission_title),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                maxLines = 1
            )
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = CircleShape
                    )
                    .clickable(onClick = { onClick }),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(22.dp),
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }

        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = context.getString(R.string.permission_des),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            ),
            maxLines = 3
        )
        Spacer(Modifier.height(16.dp))
        PermissionComp(
            modifier = Modifier
                .padding(8.dp),
            title = context.getString(R.string.notification),
            subTitle = context.getString(R.string.notification_des),
            icon = Icons.Filled.Notifications,
            onClick = {},
        )
        PermissionComp(
            modifier = Modifier
                .padding(8.dp),
            title = context.getString(R.string.storage),
            subTitle = context.getString(R.string.storage_des),
            icon = Icons.Outlined.Storage,
            onClick = {},
        )
        PermissionComp(
            modifier = Modifier
                .padding(8.dp),
            title = context.getString(R.string.notification),
            subTitle = context.getString(R.string.notification_des),
            icon = Icons.Filled.Notifications,
            onClick = { },
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = context.getString(R.string.permission_bottom_des),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            ),
            maxLines = 3
        )
        Spacer(Modifier.weight(1f))
        OutlinedButton(
            onClick = {
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = context.getString(R.string.btn_txt)
            )
        }
    }
}

