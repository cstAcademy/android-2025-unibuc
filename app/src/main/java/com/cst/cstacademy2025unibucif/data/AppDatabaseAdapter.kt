package com.cst.cstacademy2025unibucif.data

import android.content.Context
import androidx.room.Room
import com.cst.cstacademy2025unibucif.data.repositories.cities.CitiesRepository
import com.cst.cstacademy2025unibucif.data.repositories.cities.CitiesRepositoryLocal
import com.cst.cstacademy2025unibucif.data.repositories.directions.DirectionsRepository
import com.cst.cstacademy2025unibucif.data.repositories.directions.DirectionsRepositoryLocal
import com.cst.cstacademy2025unibucif.data.repositories.users.UsersRepository
import com.cst.cstacademy2025unibucif.data.repositories.users.UsersRepositoryLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDatabaseAdapter {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "local_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCitiesRepository(appDatabase: AppDatabase): CitiesRepository = CitiesRepositoryLocal(appDatabase.citiesDAO)

    @Provides
    @Singleton
    fun provideDirectionsRepository(appDatabase: AppDatabase): DirectionsRepository = DirectionsRepositoryLocal(appDatabase.directionsDAO)

    @Provides
    @Singleton
    fun provideUsersRepository(appDatabase: AppDatabase): UsersRepository = UsersRepositoryLocal(appDatabase.usersDao)
}