package com.architecture.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.architecture.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sven.Wong on 2020-02-10
 */



@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
            AppDatabase::class.java, "example-db").build()
    }

}