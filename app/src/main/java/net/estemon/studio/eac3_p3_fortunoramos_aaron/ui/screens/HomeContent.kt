package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun ListOnlyContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    selectedBook: BookEntity
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
    ) {
        BookList(
            contentType,
            appUiState,
            onBookCardPressed,
            onBackPressed,
            selectedBook
        )
    }
}

@Composable
fun BottomListAndDetailContent(
    books: List<BookEntity>,
    onBookCardPressed: (BookEntity) -> Unit,
    selectedBook: BookEntity,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            StandardDetailContent(
                book = selectedBook,
                modifier = Modifier
                    .weight(1f)
            )
            HorizontalBookshelf(
                books = books,
                onBookCardPressed = onBookCardPressed,
                book = selectedBook,
                modifier = modifier
                    .width(150.dp)
            )
        }
    }
}

@Composable
fun LeftListAndDetailContent(
    books: List<BookEntity>,
    onBookCardPressed: (BookEntity) -> Unit,
    selectedBook: BookEntity,
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .width(150.dp)
        ) {
            VerticalBookshelf(
                books = books,
                onBookCardPressed = onBookCardPressed,
                book = selectedBook,
                modifier = modifier
            )
        }

        StandardDetailContent(
            book = selectedBook,
            modifier = Modifier
                .weight(1f)
        )
    }
}