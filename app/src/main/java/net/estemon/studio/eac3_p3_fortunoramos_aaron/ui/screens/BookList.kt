package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState

@Composable
fun BookList(
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    when (appUiState) {
        is AppUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AppUiState.Success -> HorizontalBookshelf(appUiState.books, modifier)
        is AppUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
        is AppUiState.Empty -> EmptyScreen(modifier = modifier.fillMaxSize())
        is AppUiState.BookSelected -> ListAndDetailContent(appUiState = appUiState, onBookCardPressed)
    }
}

@Composable
fun CommonScreen(text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    CommonScreen("LOADING DATA")
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    CommonScreen("ERROR")
}

@Composable
fun EmptyScreen(modifier: Modifier = Modifier) {
    CommonScreen("NO RESULTS")
}

@Composable
fun BookCard(
    book: BookEntity,
    modifier: Modifier
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(book.thumbnail)
            .crossfade(true)
            .build(),
        contentDescription = book.id,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        loading = { CircularProgressIndicator() }
    )
}

@Composable
fun VerticalBookshelf(
    books: List<BookEntity>,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = books,
            key = { book -> book.id }
        ) { book ->
            BookCard(
                book = book,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}

@Composable
fun HorizontalBookshelf(
    books: List<BookEntity>,
    modifier: Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = books,
            key = { book -> book.id }
        ) { book ->
            BookCard(
                book = book,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}