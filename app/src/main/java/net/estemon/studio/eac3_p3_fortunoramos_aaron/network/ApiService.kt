package net.estemon.studio.eac3_p3_fortunoramos_aaron.network

import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("volumes")
    suspend fun getBooks(@Query("q)") query: String): BookResponse
}