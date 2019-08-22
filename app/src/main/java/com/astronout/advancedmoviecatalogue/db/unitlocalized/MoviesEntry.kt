package com.astronout.advancedmoviecatalogue.db.unitlocalized

import androidx.room.ColumnInfo

data class MoviesEntry(
    @ColumnInfo(name = "title")
    override val title: String,
    @ColumnInfo(name = "overview")
    override val overview: String,
    @ColumnInfo(name = "posterPath")
    override val posterPath: String,
    @ColumnInfo(name = "releaseDate")
    override val releaseDate: String,
    @ColumnInfo(name = "voteAverage")
    override val voteAverage: Double,
    @ColumnInfo(name = "backdropPath")
    override val backdropPath: String
): UnitSpecificMoviesEntry