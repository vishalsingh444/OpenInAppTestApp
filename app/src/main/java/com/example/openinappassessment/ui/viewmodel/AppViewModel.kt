package com.example.openinappassessment.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappassessment.data.model.DataModel
import com.example.openinappassessment.repository.NetworkDataRepository
import java.time.LocalTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: NetworkDataRepository
) : ViewModel(){

    private val _uiState = mutableStateOf(DataModel())
    val uiState: State<DataModel> = _uiState
    private val _topLinks = mutableStateOf(true)
    val topLinkSelected: State<Boolean> = _topLinks
    init{
        viewModelScope.launch {
            val response = repository.getData()
            _uiState.value = response
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getGreeting(): String {
        val calendar = Calendar.getInstance()
        val currentTime = calendar.get(Calendar.HOUR_OF_DAY)

        return when {
            currentTime < 6 -> "Good night"
            currentTime < 12 -> "Good morning"
            currentTime < 18 -> "Good afternoon"
            else -> "Good evening"
        }
    }
    fun updateTopLinkSelectedButton(selected: Boolean){
        _topLinks.value = selected
    }
    val analyticsList = listOf<Pair<String,String>>(
        Pair("Total Clicks",uiState.value.total_clicks.toString()),
        Pair("Today's Clicks",uiState.value.today_clicks.toString()),
        Pair("Total links",uiState.value.total_links.toString()),
        Pair("Top location",uiState.value.top_location),
        Pair("Top source",uiState.value.top_source)
        )
}