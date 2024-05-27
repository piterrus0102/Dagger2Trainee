package com.piterrus.dagger2.presentation.subcomponent_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.piterrus.dagger2.App

@Composable
fun SubcomponentScreen() {

    val component = remember { App.appComponent.getSubcomponent() }
    val viewModel = remember { component.getSubcomponentViewModel() }
    val state = viewModel.state.collectAsState().value
    LaunchedEffect(key1 = Unit) {
        viewModel.getResultOfSomeLongOperation()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(0.2F)
                    .aspectRatio(1F)
            )
        } else {
            Text(
                text = state.stringForDisplaying,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

    }
}