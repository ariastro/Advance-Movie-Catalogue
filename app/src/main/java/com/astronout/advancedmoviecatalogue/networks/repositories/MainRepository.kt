package com.astronout.advancedmoviecatalogue.networks.repositories

import com.astronout.advancedmoviecatalogue.models.MoviesResponse
import com.astronout.advancedmoviecatalogue.networks.ApiObserver
import com.astronout.advancedmoviecatalogue.networks.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService = Service.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestListUpcomingMovie(onResult: (MoviesResponse) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getUpcomingMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<MoviesResponse>(compositeDisposable) {
                override fun onApiSuccess(data: MoviesResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }

            })
    }

    fun requestListNowPlayingMovie(onResult: (MoviesResponse) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getNowPlayingMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<MoviesResponse>(compositeDisposable) {
                override fun onApiSuccess(data: MoviesResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }

            })
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

}