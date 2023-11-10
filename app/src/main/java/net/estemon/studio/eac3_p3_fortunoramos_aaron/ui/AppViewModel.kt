package net.estemon.studio.eac3_p3_fortunoramos_aaron.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookEntity
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BooksieRepository
import java.io.IOException

sealed interface ApiServiceUiState {
    data class Success(val books: List<BookEntity>) : ApiServiceUiState
    object Error: ApiServiceUiState
    object Loading: ApiServiceUiState
    object Empty: ApiServiceUiState
}
class AppViewModel(
    private val booksieRepository: BooksieRepository
) : ViewModel() {

    var apiServiceUiState: ApiServiceUiState by mutableStateOf(ApiServiceUiState.Loading)
        private set

    init {
        getBooks(query = "jazz")
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            apiServiceUiState = ApiServiceUiState.Loading
            try {
                val books = booksieRepository.getBooks(query)
                apiServiceUiState = if (books.isNotEmpty()) {
                    ApiServiceUiState.Success(books)
                } else {
                    ApiServiceUiState.Empty
                }
            } catch (e: IOException) {
                ApiServiceUiState.Error
            }
        }
    }

}