package com.piterrus.dagger2.compose.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piterrus.dagger2.R
import com.piterrus.dagger2.compose.theme.Dagger2TraineeTheme

@Composable
fun TopNavBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackButtonClicked: (() -> Unit)?,
    onNextButtonClicked: (() -> Unit)?
) {
    Surface {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                onBackButtonClicked?.let {
                    IconButton(
                        onClick = {
                            onBackButtonClicked.invoke()
                        },
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_16_arrow_left),
                                contentDescription = null,

                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface)
                            )
                        }
                    )
                }
                onNextButtonClicked?.let {
                    Spacer(modifier = Modifier.weight(1F))
                    IconButton(
                        onClick = {
                            onNextButtonClicked.invoke()
                        },
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_16_arrow_right),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface)
                            )
                        }
                    )
                }

            }
        }

    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun TopNavBar_Preview1() {
    Dagger2TraineeTheme {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()

        ) {
            TopNavBar(
                title = "Buttons",
                onBackButtonClicked = {},
                onNextButtonClicked = {}
            )
        }
    }
}