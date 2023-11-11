package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOnlyContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit
) {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            ),
        topBar = { TopAppBar(scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BookList(
                contentType,
                appUiState,
                onBookCardPressed,
                onBackPressed
            )
        }
    }
}

@Composable
fun ListAndDetailContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {
    if (contentType == AppContentType.HORIZONTAL_LIST_AND_DETAIL) {
        HorizontalListAndDetailContent(
            appUiState,
            onBookCardPressed
        )
    } else {
        VerticalListAndDetailContent(
            appUiState,
            onBookCardPressed
        )
    }
}

@Composable
fun HorizontalListAndDetailContent(
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {

}

@Composable
fun VerticalListAndDetailContent(
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit
) {

}