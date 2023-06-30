package com.example.openinappassessment.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassessment.R
import com.example.openinappassessment.ui.components.HorizontalList
import com.example.openinappassessment.ui.components.LinksTabComponent
import com.example.openinappassessment.ui.components.RecentLinksTabComponent
import com.example.openinappassessment.ui.theme.blue
import com.example.openinappassessment.ui.theme.grey
import com.example.openinappassessment.ui.viewmodel.AppViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(
    viewModel: AppViewModel,
) {
    LazyColumn(
        modifier = Modifier
            .background(grey)
            .padding(start = 16.dp, end = 16.dp, top = 136.dp, bottom = 20.dp)
            .graphicsLayer(
                shape = MaterialTheme.shapes.medium,
                clip = true,
            ),
    ) {
        item {
            Text(
                text = viewModel.getGreeting(),
                fontSize = 16.sp,
                lineHeight = 24.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.userName),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalList(list = viewModel.analyticsList)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),

                ) {
                Text(
                    text = "View Analytics",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Button(
                    onClick = { viewModel.updateTopLinkSelectedButton(true) },
                    colors = if (viewModel.topLinkSelected.value) ButtonDefaults.buttonColors(blue) else ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, contentColor = Color.Black
                    ),

                ) {
                    Text(text = "Top Links")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { viewModel.updateTopLinkSelectedButton(false) },
                    colors = if (!viewModel.topLinkSelected.value) ButtonDefaults.buttonColors(blue) else ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, contentColor = Color.Black
                    )
                ) {
                    Text(text = "Recent Links")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        if (viewModel.topLinkSelected.value) {
            items(viewModel.uiState.value.data.top_links) { link ->
                LinksTabComponent(link = link)
                Spacer(modifier = Modifier.height(16.dp))
            }
        } else {
            items(viewModel.uiState.value.data.recent_links) { link ->
                RecentLinksTabComponent(link = link)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}