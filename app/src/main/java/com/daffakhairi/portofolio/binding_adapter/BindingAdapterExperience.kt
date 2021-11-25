package com.daffakhairi.portofolio.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.daffakhairi.portofolio.Portofolio

@BindingAdapter("experienceTitle")
fun TextView.setExperienceTitle(data: Portofolio?) {
    data?.let {
        text = data.title
    }
}

@BindingAdapter("experienceDetail")
fun TextView.setExperienceDetail(data: Portofolio?) {
    data?.let {
        text = data.detail
    }
}

@BindingAdapter("experienceImage")
fun ImageView.setExperienceImage(data: Portofolio) {
    load(data.image) {
        crossfade(1000)
    }
}