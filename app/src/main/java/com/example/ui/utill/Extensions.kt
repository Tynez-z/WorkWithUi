package com.example.ui //TODO replace package

import android.view.View
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter

@BindingAdapter("question_no_button") //TODO rename what is question_no_button
fun Button.setVisibilityOfNoClick(type: String?) {
    background = when (type) {
        BUTTON_BLUE -> getDrawable(context, R.drawable.btn_normal)
        BUTTON_GREY -> getDrawable(context, R.drawable.btn_selected)
        else -> getDrawable(context, R.drawable.btn_normal)
    }
    setTextColor(
            when (type) {
                BUTTON_BLUE -> getColor(context, R.color.text_grey)
                BUTTON_GREY -> getColor(context, R.color.white)
                else -> getColor(context, R.color.text_grey)
            }
    )
}

fun View.makeVisible() { visibility = View.VISIBLE }
fun View.makeInvisible() { visibility = View.INVISIBLE }