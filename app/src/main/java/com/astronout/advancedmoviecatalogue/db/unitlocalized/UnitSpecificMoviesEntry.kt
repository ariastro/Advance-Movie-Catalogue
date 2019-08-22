package com.astronout.advancedmoviecatalogue.db.unitlocalized

interface UnitSpecificMoviesEntry {
    val title: String
    val overview: String
    val posterPath: String
    val releaseDate: String
    val voteAverage: Double
    val backdropPath: String
}