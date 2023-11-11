package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(
    contentType: AppContentType,
    appUiState: AppUiState,
    onBookCardPressed: (BookEntity) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                //.fillMaxSize()
                .background(Color.Yellow)
        ) {
            Column(
                modifier = Modifier
                    //.fillMaxSize()
                    .background(Color.DarkGray)
                    //.background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                if (contentType == AppContentType.LIST_OR_DETAIL) {
                    ListOnlyContent(
                        contentType,
                        appUiState,
                        onBookCardPressed,
                        onBackPressed,
                        scrollBehavior
                    )
                } else {
                    ListAndDetailContent(
                        contentType,
                        appUiState,
                        onBookCardPressed,
                        scrollBehavior
                    )
                }
            }
        }
    }
}