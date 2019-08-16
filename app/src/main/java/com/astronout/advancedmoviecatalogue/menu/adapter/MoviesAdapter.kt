package com.astronout.advancedmoviecatalogue.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.astronout.advancedmoviecatalogue.R
import com.astronout.advancedmoviecatalogue.databinding.ItemMovieBinding
import com.astronout.advancedmoviecatalogue.menu.models.Result
import com.astronout.advancedmoviecatalogue.utils.AdapterCallback
import com.astronout.advancedmoviecatalogue.menu.item.viewmodels.ItemMovieViewModel

class MoviesAdapter(val onClick:(Result) -> Unit): ListAdapter<Result, MoviesAdapter.MoviesViewHolder>(AdapterCallback.DiffListCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding = DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movieModel = getItem(holder.adapterPosition)
        holder.bindData(movieModel)
        holder.itemView.setOnClickListener {
            onClick(movieModel)
        }
    }

    class MoviesViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var viewModel: ItemMovieViewModel
        fun bindData(movieModel: Result) {
            viewModel = ItemMovieViewModel(movieModel)
            binding.itemMovie = viewModel
            binding.executePendingBindings()
        }

    }

}