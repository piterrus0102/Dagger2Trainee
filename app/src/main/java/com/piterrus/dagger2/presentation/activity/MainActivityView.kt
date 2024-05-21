package com.piterrus.dagger2.presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piterrus.dagger2.R
import com.piterrus.dagger2.ui.theme.Dagger2TraineeTheme


@Composable
fun MainActivityView(
    onIntent: (MainActivityIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(.4F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnProvidesClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.provides),
                        textAlign = TextAlign.Center
                    )
                }
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(.6F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnBindsClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.binds),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Dagger2TraineeTheme {
        MainActivityView(
            onIntent = {}
        )
    }
}