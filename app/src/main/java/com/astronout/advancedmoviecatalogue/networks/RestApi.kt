package com.astronout.advancedmoviecatalogue.networks

import com.astronout.advancedmoviecatalogue.BuildConfig
import com.astronout.advancedmoviecatalogue.models.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("upcoming?api_key=" + BuildConfig.THE_MOVIE_DB_API_TOKEN)
    fun getUpcomingMovies(): Observable<MoviesResponse>

    @GET("now_playing?api_key=" + BuildConfig.THE_MOVIE_DB_API_TOKEN)
    fun getNowPlayingMovies(): Observable<MoviesResponse>

}