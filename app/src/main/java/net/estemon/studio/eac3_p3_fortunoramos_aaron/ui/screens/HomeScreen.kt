package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.AppUiState
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun AppHomeScreen(
    contentType: AppContentType,
    appUiState: AppUiState,
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
            onBackPressed = onDetailScreenBackPressed,
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
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                if (contentType == AppContentType.LIST_OR_DETAIL) {
                    ListOnlyContent(
                        contentType,
                        appUiState,
                        onBookCardPressed,
                        onBackPressed
                    )
                } else {
                    ListAndDetailContent(
                        contentType,
                        appUiState,
                        onBookCardPressed
                    )
                }
            }
        }
    }
}