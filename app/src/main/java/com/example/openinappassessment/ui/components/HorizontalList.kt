package com.example.openinappassessment.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassessment.R


@Composable
fun HorizontalList(list: List<Pair<String, String>>) {
    LazyRow(
        modifier = Modifier,
    ) {
        items(list) { item ->
            AnalyticComponent(name = item.first, info = item.second)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun AnalyticComponent(name: String, info: String) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.left_click_40px),
                contentDescription = name
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = info,
                Modifier.padding(4.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = name,
                fontSize = 14.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}