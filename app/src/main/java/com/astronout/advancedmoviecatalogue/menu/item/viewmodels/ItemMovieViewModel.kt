package com.astronout.advancedmoviecatalogue.menu.item.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.astronout.advancedmoviecatalogue.menu.models.Result

class ItemMovieViewModel(private val model: Result) : ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var posterPath: ObservableField<String> = ObservableField()
    var voteAverage: ObservableField<Double> = ObservableField()
    var releaseDate: ObservableField<String> = ObservableField()
    var overview: ObservableField<String> = ObservableField()

    init {
        title.set(model.title)
        posterPath.set("http://image.tmdb.org/t/p/w500" + model.posterPath)
        voteAverage.set(model.voteAverage)
        releaseDate.set(model.releaseDate)
        overview.set(model.overview)
    }

//    fun itemClick(view: View){
//        val context = view.context
//        val intent = Intent(context, DetailActivity::class.java)
////        val intent = Intent(context, DetailMoviesFragment::class.java)
//        intent.putExtra(DetailActivity.EXTRA_DATA_GALLERY, model)
//        context.startActivity(intent)
//    }

}