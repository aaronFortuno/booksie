package net.estemon.studio.eac3_p3_fortunoramos_aaron

import android.app.Application
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.AppContainer
import net.estemon.studio.eac3_p3_fortunoramos_aaron.data.DefaultAppContainer

class BooksieApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}