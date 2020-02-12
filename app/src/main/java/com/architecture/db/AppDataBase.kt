package com.architecture.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.architecture.db.dao.ExampleDao
import com.architecture.db.entities.Example

/**
 * Created by Sven.Wong on 2020-02-10
 */

@Database(entities = arrayOf(Example::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}