package com.astronout.advancedmoviecatalogue.utils

import androidx.recyclerview.widget.DiffUtil
import com.astronout.advancedmoviecatalogue.models.Result

class AdapterCallback {

    companion object {

        /**
         * diff callback adapter list
         */
        val DiffListCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.title == newItem.title
            }
        }

    }



}