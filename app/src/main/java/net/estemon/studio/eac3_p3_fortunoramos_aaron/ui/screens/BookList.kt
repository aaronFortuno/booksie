package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun BookList(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    selectedBook: BookEntity,
    modifier: Modifier = Modifier
) {
    when (appUiState) {
        is AppUiState.Loading -> LoadingScreen()
        is AppUiState.Error -> ErrorScreen()
        is AppUiState.Empty -> EmptyScreen()
        is AppUiState.Success ->
            if (contentType == AppContentType.BOTTOM_LIST_AND_DETAIL) {
                HorizontalBookshelf(
                    books = appUiState.books,
                    onBookCardPressed = onBookCardPressed,
                    book = selectedBook,
                    modifier
                )
            } else if (contentType == AppContentType.LIST_OR_DETAIL) {
                ListOnlyBookshelf(
                    books = appUiState.books,
                    onBookCardPressed = onBookCardPressed,
                    modifier
                )
            } else {
                VerticalBookshelf(
                    books = appUiState.books,
                    onBookCardPressed = onBookCardPressed,
                    book = selectedBook,
                    modifier
                )
            }
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
fun LoadingScreen() {
    CommonScreen("LOADING DATA")
}

@Composable
fun ErrorScreen() {
    CommonScreen("ERROR")
}

@Composable
fun EmptyScreen() {
    CommonScreen("NO RESULTS")
}

@Composable
fun BookListCard(
    book: BookEntity,
    onBookCardPressed: (BookEntity) -> Unit,
    modifier: Modifier
) {
    SubcomposeAsyncImage(
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
            .clickable { onBookCardPressed(book) }
    )
}

@Composable
fun VerticalBookshelf(
    books: List<BookEntity>,
    onBookCardPressed: (BookEntity) -> Unit,
    book: BookEntity,
    modifier: Modifier
) {
    Row {
        LazyColumn(
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
                .width(150.dp)
        ) {
            items(books) {book ->
                BookListCard(
                    book = book,
                    onBookCardPressed = { onBookCardPressed(book) },
                    modifier = modifier
                        .padding(4.dp)
                        .aspectRatio(1.5f),

                    )
            }
        }
        book?.let {
            StandardDetailContent(
                book = book,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }

}

@Composable
fun HorizontalBookshelf(
    books: List<BookEntity>,
    onBookCardPressed: (BookEntity) -> Unit,
    book: BookEntity,
    modifier: Modifier,

) {
    Column {
        book?.let {
            StandardDetailContent(
                book = book,
                modifier = Modifier
                    .weight(1f)
            )
        }
        LazyRow(
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
                .height(150.dp)
        ) {
            items(books) {book ->
                BookListCard(
                    book = book,
                    onBookCardPressed = { onBookCardPressed(book) },
                    modifier = modifier
                        .padding(4.dp)
                        .aspectRatio(1.5f)
                )
            }
        }
    }


}

@Composable
fun ListOnlyBookshelf (
    books: List<BookEntity>,
    onBookCardPressed: (BookEntity) -> Unit,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier

    ) {
        items(
            items = books,
            key = { book -> book.id }
        ) { book ->
            BookListCard(
                book = book,
                onBookCardPressed = onBookCardPressed,
                modifier = modifier
                    .padding(4.dp)
                    .aspectRatio(1.5f)
            )
        }
    }
}
