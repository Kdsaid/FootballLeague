package com.example.footballleague.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun AppCompatActivity.scrollable() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setSoftInputMode(
        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
    )
}

fun Context.goTo(dest: AppCompatActivity, name: String = "", value: String = "") {
    startActivity(Intent(this, dest::class.java).apply {
        putExtra(name, value)
    })



    fun Context.CgotoUrl1(url: String) {

        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    fun Context.share(message: String="") {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(
            Intent.EXTRA_TEXT, ""
        )
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, ""))
    }

}

