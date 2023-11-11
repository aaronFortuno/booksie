package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOnlyContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    Surface(
        modifier = Modifier
            //.fillMaxSize()
            .padding(4.dp)
    ) {
        BookList(
            contentType,
            appUiState,
            onBookCardPressed,
            onBackPressed
        )
    }
    /*Scaffold(
        modifier = Modifier
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            ),
        topBar = {
            TopAppBar(
                scrollBehavior
            )
        }
    ) {
        Surface(
            modifier = Modifier
                //.fillMaxSize()
                .padding(it)
        ) {
            BookList(
                contentType,
                appUiState,
                onBookCardPressed,
                onBackPressed
            )
        }
    }*/
}

@Composable
fun ListAndDetailContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {
    if (contentType == AppContentType.BOTTOM_LIST_AND_DETAIL) {
        BottomListAndDetailContent(
            contentType,
            appUiState,
            onBookCardPressed
        )
    } else {
        LeftListAndDetailContent(
            contentType,
            appUiState,
            onBookCardPressed
        )
    }
}

@Composable
fun BottomListAndDetailContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            StandardDetailLayout(
                appUiState = appUiState,
                modifier = Modifier
                    .weight(1f)
            )
            BookList(
                contentType = contentType,
                appUiState = appUiState,
                onBookCardPressed = onBookCardPressed,
                onBackPressed = { },
                modifier = Modifier
                    .height(150.dp)
            )
        }
    }
}

@Composable
fun LeftListAndDetailContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .width(150.dp)
        ) {
            BookList(
                contentType = contentType,
                appUiState = appUiState,
                onBookCardPressed = onBookCardPressed,
                onBackPressed = { }
            )
        }

        StandardDetailLayout(
            appUiState = appUiState,
            modifier = Modifier
                .weight(1f)
        )
    }
}