package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity

@Composable
fun CompactDetailsScreen() {

}

@Composable
fun StandardDetailContent(
    book: BookEntity,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
    ) {
        StandardDetailBookImage(
            book,
            modifier = Modifier
                .weight(1f)
        )
        StandardDetailBookData(
            book,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun StandardDetailBookImage(
    book: BookEntity,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
    ) {
        /*SubcomposeAsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.thumbnail)
                .crossfade(true)
                .build(),
            contentDescription = book.id,
            contentScale = ContentScale.Crop,
            loading = { CircularProgressIndicator() },
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        )*/
        Text(text = book.thumbnail)
    }
}

@Composable
fun StandardDetailBookData(
    book: BookEntity,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
    ) {
        Text(book.id)
    }
}