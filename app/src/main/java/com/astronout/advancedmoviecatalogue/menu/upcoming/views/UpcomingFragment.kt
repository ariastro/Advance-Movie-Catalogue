package com.astronout.advancedmoviecatalogue.menu.upcoming.views

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
import com.astronout.advancedmoviecatalogue.databinding.FragmentUpcomingBinding
import com.astronout.advancedmoviecatalogue.menu.adapter.MoviesAdapter
import com.astronout.advancedmoviecatalogue.menu.upcoming.viewmodels.UpcomingViewModel
import com.astronout.advancedmoviecatalogue.menu.models.Result

class UpcomingFragment : Fragment() {

    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var viewModel: UpcomingViewModel

    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming, container, false)
        viewModel = ViewModelProviders.of(this).get(UpcomingViewModel::class.java)
        binding.upcoming = viewModel

        setUpRecyclerView()
        observeLiveData()

        viewModel.getListUpcomingMovie()

        return binding.root
    }

//    private fun observeLiveData() {
//        viewModel.listMovie.observe(this, Observer {
//            adapter.setData(it?.results!!)
//            adapter.notifyDataSetChanged()
//        })
//        viewModel.error.observe(this, Observer {
//
//        })
//    }

    private fun observeLiveData() {
        viewModel.listMovie.observe(this, Observer {
            adapter.submitList(it?.results!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }

//
//    private fun setUpRecyclerView() {
//        val layoutManager = GridLayoutManager(context, 2)
//        binding.rvUpcoming.layoutManager = layoutManager
//        adapter = MovieAdapter(activity!!)
//        binding.rvUpcoming.adapter = adapter
//    }

    private fun setUpRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvUpcoming.layoutManager = layoutManager
        adapter = MoviesAdapter{
            d("clicked", it.title)
            onItemClick(it)
        }
        binding.rvUpcoming.adapter = adapter
    }

    private fun onItemClick(movieModel: Result) {
        val action = UpcomingFragmentDirections.actionUpcomingToDetail()
        action.dataDetailMovies = movieModel
        findNavController().navigate(action)
    }

}
