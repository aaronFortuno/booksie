package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.DefaultAppContainer
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.screens.AppHomeScreen
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.utils.AppContentType

@Composable
fun BooksieApp(
    windowWidth: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    windowHeight: WindowHeightSizeClass = WindowHeightSizeClass.Medium,
    modifier: Modifier = Modifier
) {
    val appContainer = DefaultAppContainer()
    val booksieRepository = appContainer.booksieRepository
    val viewModel: AppViewModel = viewModel(factory = AppViewModelFactory(booksieRepository))
    val appUiState = viewModel.apiServiceUiState
    val isShowingHomepage = viewModel.isShowingHomepage
    val contentType: AppContentType

    when (windowHeight) {
        WindowHeightSizeClass.Compact -> {
            contentType = AppContentType.LEFT_LIST_AND_DETAIL
        }
        WindowHeightSizeClass.Medium -> {
            if (windowWidth == WindowWidthSizeClass.Compact) {
                contentType = AppContentType.LIST_OR_DETAIL
            } else if (windowWidth == WindowWidthSizeClass.Medium) {
                contentType = AppContentType.BOTTOM_LIST_AND_DETAIL
            } else {
                contentType = AppContentType.LEFT_LIST_AND_DETAIL
            }
        }
        else -> {
            contentType = AppContentType.BOTTOM_LIST_AND_DETAIL
        }
    }

    AppHomeScreen(
        contentType = contentType,
        appUiState = appUiState,
        isShowingHomepage = isShowingHomepage,
        onBookCardPressed = { book: BookEntity ->
            viewModel.onBookSelected(book)
        },
        onDetailScreenBackPressed = {
            viewModel.onBackToList()
        },
        appViewModel = viewModel,
        modifier = modifier
    )
}