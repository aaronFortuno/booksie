package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun BooksieApp(
    windowWidth: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    windowHeight: WindowHeightSizeClass = WindowHeightSizeClass.Medium,
    modifier: Modifier = Modifier
) {
    val viewModel: AppViewModel = viewModel()
    val appUiState = viewModel.apiServiceUiState
    val contentType: AppContentType

    when (windowWidth) {
        WindowWidthSizeClass.Compact -> {
            contentType = AppContentType.LIST_OR_DETAIL
        }
        WindowWidthSizeClass.Medium -> {
            if (windowHeight == WindowHeightSizeClass.Compact) {
                contentType = AppContentType.VERTICAL_LIST_AND_DETAIL
            } else {
                contentType = AppContentType.HORIZONTAL_LIST_AND_DETAIL
            }
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = AppContentType.HORIZONTAL_LIST_AND_DETAIL
        }
        else -> {
            contentType = AppContentType.HORIZONTAL_LIST_AND_DETAIL
        }
    }



}