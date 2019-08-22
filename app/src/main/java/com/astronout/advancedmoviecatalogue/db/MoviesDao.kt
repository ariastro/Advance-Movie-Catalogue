package com.astronout.advancedmoviecatalogue.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.astronout.advancedmoviecatalogue.db.unitlocalized.MoviesEntry
import com.astronout.advancedmoviecatalogue.menu.models.MOVIES_ID
import com.astronout.advancedmoviecatalogue.menu.models.Result

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(moviesEntry: Result)

    @Query("SELECT * FROM movies WHERE id = $MOVIES_ID")
    fun getMovies(): LiveData<MoviesEntry>
}