package com.astronout.advancedmoviecatalogue.menu.detail.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.astronout.advancedmoviecatalogue.R
import com.astronout.advancedmoviecatalogue.databinding.FragmentDetailMoviesBinding
import com.astronout.advancedmoviecatalogue.main.views.MainActivity
import com.astronout.advancedmoviecatalogue.menu.detail.viewmodels.CustomDetailMovieViewModelFactory
import com.astronout.advancedmoviecatalogue.menu.detail.viewmodels.DetailMovieViewModel
import com.astronout.advancedmoviecatalogue.models.Result

class DetailMoviesFragment : Fragment() {

    private lateinit var binding: FragmentDetailMoviesBinding
    private lateinit var viewModel: DetailMovieViewModel
    private val args: DetailMoviesFragmentArgs by navArgs()
    private var movieModel: Result? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        movieModel = args.dataDetailMovies
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_movies, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideNavigation(true)
        viewModel = ViewModelProviders.of(this, CustomDetailMovieViewModelFactory(movieModel!!, activity!!.application)).get(
            DetailMovieViewModel::class.java)
        binding.detailMovie = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).hideNavigation(false)
    }

}
