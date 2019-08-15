package com.astronout.advancedmoviecatalogue.menu.detail.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.astronout.advancedmoviecatalogue.models.Result

class DetailMovieViewModel(movieModel: Result?, application: Application) : AndroidViewModel(application) {

    var imageUrl: ObservableField<String> = ObservableField("http://image.tmdb.org/t/p/w500" + movieModel?.posterPath!!)
    var backDropUrl: ObservableField<String> = ObservableField("http://image.tmdb.org/t/p/w500" + movieModel?.backdropPath!!)
    var rating: ObservableField<Double> = ObservableField(movieModel?.voteAverage!!)
    var releaseDate: ObservableField<String> = ObservableField("Release Date: " + movieModel?.releaseDate!!)
    var overview: ObservableField<String> = ObservableField(movieModel?.overview!!)
    var title: ObservableField<String> = ObservableField(movieModel?.title!!)

}