package com.astronout.advancedmoviecatalogue.utils.binding

import android.animation.Animator
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.astronout.advancedmoviecatalogue.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

class BindingConverters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView.context)
                .load(url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_refresh_black_24dp)
                        .error(R.drawable.ic_refresh_black_24dp)
                        .format(DecodeFormat.PREFER_ARGB_8888))
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("hideView")
        fun hideView(view: View, status: Boolean){
            if (status) {
                view.visibility = View.VISIBLE
                view.alpha = 1F
            } else {
                view.animate().alpha(0F).setDuration(300L).setListener(object : Animator.AnimatorListener{
                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                    override fun onAnimationStart(p0: Animator?) {

                    }

                })
            }
        }

    }
}