package com.cst.cstacademy2025unibucif.helpers.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cst.cstacademy2025unibucif.R

@BindingAdapter("imageUrl")
fun loadImageFromURL(imageView: ImageView, url: String) {
    Glide
        .with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView)
}
