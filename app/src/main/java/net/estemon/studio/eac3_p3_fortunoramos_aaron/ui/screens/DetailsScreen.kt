package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity

@Composable
fun CompactDetailsScreen(
    book: BookEntity,
    isShowingHomepage: Boolean,
    onBackPressed: (BookEntity) -> Unit,
    modifier: Modifier
) {
    Column {
        TopAppBar(
            isShowingHomepage,
            onBackPressed
        )
        Column(modifier = Modifier.padding(16.dp)) {
            StandardDetailBookData(
                book = book,
                modifier = modifier
            )
            StandardDetailBookImage(book = book, modifier = modifier.size(250.dp))

        }
    }
}

@Composable
fun StandardDetailContent(
    book: BookEntity,
    onBackPressed: (BookEntity) -> Unit,
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
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.thumbnail)
                .crossfade(true)
                .build(),
            contentDescription = book.id,
            contentScale = ContentScale.Fit,
            loading = { CircularProgressIndicator() },
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        )
    }
}

@Composable
fun StandardDetailBookData(
    book: BookEntity,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxHeight()
            .padding(
                top = 16.dp,
                end = 16.dp
            )
    ) {
        BookDetailsTitle(title = book.title)
        BookDetailsSubtitle(subtitle = book.subtitle)
        BookDetailsId(id = book.id)
        Column(
            modifier = modifier
                .padding(top = 16.dp)
        ) {
            BookDetailsAuthorsList(authors = book.authors)
            BookDetailsPublisher(publisher = book.publisher)
        }

    }
}

@Composable
fun BookDetailsTitle(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun BookDetailsSubtitle(
    subtitle: String?
) {
    subtitle?.let { 
        Text(
            text = subtitle,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun BookDetailsId(
    id: String
) {
    Text(
        text = "id: $id",
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
fun BookDetailsAuthorsList(authors: List<String>?) {
    Row {
        Text(
            text = "author/s: ",
            color = MaterialTheme.colorScheme.primary
        )
        authors?.forEach {author ->
            Text(
                text = "$author",
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun BookDetailsPublisher(
    publisher: String?
) {
    Row {
        publisher?.let {
            Text(
                text = "publisher: ",
                color = MaterialTheme.colorScheme.primary
            )
            Text(text = publisher)
        }
    }

}