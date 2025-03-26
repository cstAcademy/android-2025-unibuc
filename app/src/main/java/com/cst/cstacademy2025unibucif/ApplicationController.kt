package com.cst.cstacademy2025unibucif

import android.app.Application
import androidx.room.Room
import com.cst.cstacademy2025unibucif.data.AppDatabase

class ApplicationController : Application() {
    lateinit var appDatabase: AppDatabase

    companion object {
        var instance: ApplicationController? = null

        private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        initDatabase()
    }

    private fun initDatabase() {
        appDatabase = Room.databaseBuilder(
            context = this,
            klass = AppDatabase::class.java,
            name = "local_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
