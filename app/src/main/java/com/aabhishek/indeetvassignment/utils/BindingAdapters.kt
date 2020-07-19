package com.aabhishek.indeetvassignment.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("app:load_from_file")
fun loadFromFile(view: ImageView, fileName: String) {
    view.setImageResource(
        view.context.resources.getIdentifier(fileName, "drawable", view.context.packageName)
    )
}