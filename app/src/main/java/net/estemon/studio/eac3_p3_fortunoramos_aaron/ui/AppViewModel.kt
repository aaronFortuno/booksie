package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BooksieRepository
import java.io.IOException

sealed interface AppUiState {
    data class Success(val books: List<BookEntity>) : AppUiState

    object Error: AppUiState
    object Loading: AppUiState
    object Empty: AppUiState

}
class AppViewModel(
    private val booksieRepository: BooksieRepository
) : ViewModel() {

    var apiServiceUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    private val _selectedBook = MutableStateFlow<BookEntity?>(null)
    val selectedBook: StateFlow<BookEntity?> = _selectedBook.asStateFlow()

    fun onBookSelected(book: BookEntity) {
        _selectedBook.value = book
        isShowingHomepage = false
    }
    init {
        getBooks(query = "jazz")
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            apiServiceUiState = AppUiState.Loading
            try {
                val books = booksieRepository.getBooks(query, 40)
                apiServiceUiState = if (books.isNotEmpty()) {
                    AppUiState.Success(books)
                } else {
                    AppUiState.Empty
                }
            } catch (e: IOException) {
                AppUiState.Error
            }
        }
    }

    var isShowingHomepage: Boolean by mutableStateOf(true)
        private set

    fun onBackToList() {
        isShowingHomepage = true
    }
}


@Suppress("UNCHECKED_CAST")
class AppViewModelFactory(
    private val repository: BooksieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            return AppViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}