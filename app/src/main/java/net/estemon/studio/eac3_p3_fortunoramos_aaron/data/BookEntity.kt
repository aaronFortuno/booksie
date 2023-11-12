package net.estemon.studio.eac3_p3_fortunoramos_aaron.data

import kotlinx.serialization.Serializable

@Serializable
data class BookEntity(
    val id: String,
    val thumbnail: String
)

val defaultBook = BookEntity("-1", "https://en.wikipedia.org/wiki/Book#/media/File:Books_and_Scroll_Ornament_with_Open_Book.png")

@Serializable
data class BookResponse(
    val items: List<Book>
)

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String?
)