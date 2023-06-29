package com.example.openinappassessment.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassessment.R
import com.example.openinappassessment.ui.theme.blue

@Composable
fun TopAppBar(screenName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(color = blue)
            .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = screenName,
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
        IconButton(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))) {
            Icon(
                painter = painterResource(id = R.drawable.outline_settings_24),
                contentDescription = "Setting",
                Modifier.size(width = 40.dp, height = 40.dp).clickable { },
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBar() {
    MaterialTheme{
        TopAppBar(screenName = "DashBoard");
    }
}