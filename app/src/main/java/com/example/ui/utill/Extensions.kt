package com.example.ui.utill

import android.view.View
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter
import com.example.ui.R

@BindingAdapter("set_state_btn_no") //TODO use constants
fun Button.setVisibilityOfClick(type: String?) {
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

@BindingAdapter("set_state_btn_yes")
fun Button.setVisibilityOfYesClick(type: String?) {
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

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}