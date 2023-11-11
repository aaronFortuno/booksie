package net.estemon.studio.eac3_p3_fortunoramos_aaron.data

import net.estemon.studio.eac3_p3_fortunoramos_aaron.network.ApiService

interface BooksieRepository {
    suspend fun getBooks(query: String, maxResults: Int): List<BookEntity>
}

class NetworkBooksRepository(
    private val apiService: ApiService
) : BooksieRepository {

    override suspend fun getBooks(query: String, maxResults: Int): List<BookEntity> {
        val response = apiService.getBooks(query, maxResults)
        return response.items.mapNotNull { book ->
            book.volumeInfo.imageLinks?.thumbnail?.let { thumbnail ->
                val secureThumbnail = thumbnail.replace("http", "https")
                BookEntity(id = book.id, thumbnail = secureThumbnail)
            }
        }
    }
}