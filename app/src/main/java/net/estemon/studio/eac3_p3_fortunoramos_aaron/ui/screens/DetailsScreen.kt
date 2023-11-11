package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState

@Composable
fun CompactDetailsScreen(
    appUiState: AppUiState,
    onBackPressed: () -> Unit,
    isFullScreen: Boolean = false,
    modifier: Modifier = Modifier,
) {

}

@Composable
fun CompactDetailsHeader(

) {

}

@Composable
fun CompactDetailsContent(

) {

}

@Composable
fun StandardDetailLayout(
    appUiState: AppUiState,
    modifier: Modifier
) {
    StandardDetailContent(
        modifier = modifier
    )
}



@Composable
fun StandardDetailContent(
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
    ) {
        StandardDetailBookImage(
            modifier = Modifier
                .weight(1f)
        )
        StandardDetailBookData(
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun StandardDetailBookImage(
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                BorderStroke(1.dp, Color.Green)
            )
            .fillMaxHeight()
    ) {
        Text("image")
    }
}

@Composable
fun StandardDetailBookData(
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                BorderStroke(1.dp, Color.Green)
            )
            .fillMaxHeight()

    ) {
        Text("details")
    }
}

@Composable
fun StandardDetailHeader(

) {

}