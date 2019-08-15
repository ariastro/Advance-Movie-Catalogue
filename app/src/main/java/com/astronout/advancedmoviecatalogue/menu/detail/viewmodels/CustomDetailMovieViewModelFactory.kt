package com.astronout.advancedmoviecatalogue.menu.detail.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.astronout.advancedmoviecatalogue.models.Result
import com.astronout.advancedmoviecatalogue.menu.detail.viewmodels.DetailMovieViewModel

class CustomDetailMovieViewModelFactory(private val movieModel: Result?, private val application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DetailMovieViewModel(movieModel, application) as T
    }

}