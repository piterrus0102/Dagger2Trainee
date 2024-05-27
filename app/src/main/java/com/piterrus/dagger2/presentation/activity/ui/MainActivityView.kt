package com.piterrus.dagger2.presentation.activity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piterrus.dagger2.R
import com.piterrus.dagger2.compose.theme.Dagger2TraineeTheme


@Composable
fun MainActivityView(
    onIntent: (MainActivityIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 12.dp,
                vertical = 24.dp
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.dagger_examples),
            style = MaterialTheme.typography.headlineSmall
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
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
                modifier = Modifier.fillMaxWidth(0.8F),
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

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnIntoSetAndIntoMapClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.into_set_and_into_map),
                        textAlign = TextAlign.Center
                    )
                }
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnInjectMethodClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.class_with_inject_methods),
                        textAlign = TextAlign.Center
                    )
                }
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnBuilderAndFactoryClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.component_builder_and_component_factory),
                        textAlign = TextAlign.Center
                    )
                }
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnBindsInstanceClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.binds_instance),
                        textAlign = TextAlign.Center
                    )
                }
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(0.8F),
                onClick = {
                    onIntent.invoke(MainActivityIntent.OnSubcomponentClick)
                },
                content = {
                    Text(
                        text = stringResource(id = R.string.subcomponent),
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