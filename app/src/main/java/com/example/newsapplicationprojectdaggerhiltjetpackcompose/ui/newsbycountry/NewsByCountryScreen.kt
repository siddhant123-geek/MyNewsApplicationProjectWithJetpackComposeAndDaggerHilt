package com.example.newsapplicationprojectdaggerhiltjetpackcompose.ui.newsbycountry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.ui.topheadline.TopHeadlineScreen
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.utils.IsoCodes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsByCountryRoute(
    onNewsClick: (url: String) -> Unit,
    viewModel: NewsByCountryViewModel = hiltViewModel(),
    country: String
) {
    val countryCode = IsoCodes.countryToISOCodeMap[country]
    viewModel.fetchNews(countryCode!!)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(content = { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TopHeadlineScreen(uiState, onNewsClick)
        }
    })
}