package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.ApiServiceUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun AppHomeScreen(
    contentType: AppContentType,
    appUiState: ApiServiceUiState,
    isShowingHomepage: Boolean,
    onBookCardPressed: (BookEntity) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isShowingHomepage) {
        AppContent(
            contentType = contentType,
            appUiState = appUiState,
            onBookCardPressed = onBookCardPressed,
            modifier = modifier
        )
    } else {
        CompactDetailsScreen(
            appUiState = appUiState,
            onBackPressed = onDetailScreenBackPressed,
            isFullScreen = true,
            modifier = modifier
        )
    }

}

@Composable
fun AppContent(
    contentType: AppContentType,
    appUiState: ApiServiceUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {

    }
}