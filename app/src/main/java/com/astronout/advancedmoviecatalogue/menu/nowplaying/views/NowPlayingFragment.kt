package com.astronout.advancedmoviecatalogue.menu.nowplaying.views

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.astronout.advancedmoviecatalogue.R
import com.astronout.advancedmoviecatalogue.databinding.FragmentNowPlayingBinding
import com.astronout.advancedmoviecatalogue.menu.nowplaying.viewmodels.NowPlayingViewModels
import com.astronout.advancedmoviecatalogue.menu.adapter.MoviesAdapter
import com.astronout.advancedmoviecatalogue.menu.models.Result

class NowPlayingFragment : Fragment() {

    private lateinit var binding: FragmentNowPlayingBinding
    private lateinit var viewModel: NowPlayingViewModels

    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_now_playing, container, false)
        viewModel = ViewModelProviders.of(this).get(NowPlayingViewModels::class.java)
        binding.nowPlaying = viewModel

        setUpRecyclerView()
        observeLiveData()

        viewModel.getListNowPlayingMovie(this.context)

        return binding.root
    }


    private fun observeLiveData() {
        viewModel.listMovie.observe(this, Observer {
            adapter.submitList(it?.results!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }

//    private fun setUpRecyclerView() {
//        val layoutManager = GridLayoutManager(context, 2)
//        binding.rvNowPlaying.layoutManager = layoutManager
//        adapter = MovieAdapter(activity!!)
//        binding.rvNowPlaying.adapter = adapter
//    }

    private fun setUpRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvNowPlaying.layoutManager = layoutManager
        adapter = MoviesAdapter{
            d("clicked", it.title)
            onItemClick(it)
        }
        binding.rvNowPlaying.adapter = adapter
    }

    private fun onItemClick(movieModel: Result) {
        val action = NowPlayingFragmentDirections.actionNowPlayingToDetail()
        action.dataDetailMovies = movieModel
        findNavController().navigate(action)
    }

}
