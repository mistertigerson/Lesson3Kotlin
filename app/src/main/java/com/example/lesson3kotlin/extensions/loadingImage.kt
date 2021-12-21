package com.example.lesson3kotlin.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loading(image: String){
    Glide.with(this.context)
        .load(image)
        .into(this)
}