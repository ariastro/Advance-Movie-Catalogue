package com.astronout.advancedmoviecatalogue.menu.nowplaying.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astronout.advancedmoviecatalogue.menu.models.MoviesResponse
import com.astronout.advancedmoviecatalogue.networks.repositories.MainRepository

class NowPlayingViewModels: ViewModel() {

    private val repository = MainRepository()

    val listMovie: MutableLiveData<MoviesResponse> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()
    var isLoading: ObservableField<Boolean> = ObservableField()

    fun getListNowPlayingMovie() {
        isLoading.set(true)
        repository.requestListNowPlayingMovie({
            isLoading.set(false)
            listMovie.postValue(it)
        }, {
            isLoading.set(false)
            error.postValue(it)
        })
    }
}