package net.estemon.studio.eac3_p3_fortunoramos_aaron.data

import kotlinx.serialization.Serializable

@Serializable
data class BookEntity(
    val id: String,
    val thumbnail: String
)

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