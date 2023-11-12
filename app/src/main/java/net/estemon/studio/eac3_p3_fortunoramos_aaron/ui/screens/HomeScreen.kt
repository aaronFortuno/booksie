package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.defaultBook
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppViewModel
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun AppHomeScreen(
    contentType: AppContentType,
    appUiState: AppUiState,
    isShowingHomepage: Boolean,
    onBookCardPressed: (BookEntity) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    appViewModel: AppViewModel,
    modifier: Modifier = Modifier
) {
    var showSearchBar by remember { mutableStateOf(false) }
    val selectedBook by appViewModel.selectedBook.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                if (showSearchBar) {
                    showSearchBar = false
                }
            }
    ) {
        if (isShowingHomepage) {
            AppContent(
                contentType = contentType,
                appUiState = appUiState,
                onBookCardPressed = onBookCardPressed,
                onBackPressed = onDetailScreenBackPressed,
                selectedBook = selectedBook ?: defaultBook,
                modifier = modifier,

            )
        } else {
            CompactDetailsScreen()
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            FloatingActionButton(
                onClick = { showSearchBar = !showSearchBar },
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {

                if (showSearchBar) {
                    Icon(Icons.Default.Clear, contentDescription = null)
                } else {
                    Icon(Icons.Default.Search, contentDescription = null)
                }

            }

            AnimatedVisibility(
                visible = showSearchBar,
                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
                modifier = Modifier
                    .offset(60.dp)
            ) {
                var text by remember { mutableStateOf("") }
                AppSearchBar(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = {
                        if (text.isNotBlank()) {
                            appViewModel.getBooks(text)
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
            }
        }
    }
}

@Composable
fun AppContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    selectedBook: BookEntity,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
            ) {
                if (contentType == AppContentType.LIST_OR_DETAIL) {
                    ListOnlyContent(
                        contentType,
                        appUiState,
                        onBookCardPressed,
                        onBackPressed,
                        selectedBook
                    )
                } else {
                    BookList(
                        contentType = contentType,
                        appUiState = appUiState,
                        onBookCardPressed = onBookCardPressed,
                        onBackPressed = { /*TODO*/ },
                        selectedBook = selectedBook
                    )
                }
            }
        }
    }
}