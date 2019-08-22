package com.astronout.advancedmoviecatalogue.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.astronout.advancedmoviecatalogue.menu.models.Result

@Database(
    entities = [Result::class],
    version = 1
)

abstract class MoviesDatabase: RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object{
        @Volatile private var instance: MoviesDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    MoviesDatabase::class.java, "movies.db")
                    .build()
    }
}