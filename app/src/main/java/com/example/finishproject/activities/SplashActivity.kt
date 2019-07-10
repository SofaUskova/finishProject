package com.example.finishproject.activities

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cunoraz.gifview.library.GifView
import com.example.finishproject.R

class SplashActivity : AppCompatActivity(), Animator.AnimatorListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val gifView1 = findViewById<GifView>(R.id.action_image)
        gifView1.visibility = View.VISIBLE
        gifView1.play()
        gifView1.gifResource = R.mipmap.icon


        val animation = ObjectAnimator.ofFloat(action_image, "rotationY", 0.0f, 0.0f/*360f*/)
        animation.duration = 3000
//        animation.repeatCount = ObjectAnimator.RESTART
        animation.addListener(this)
        animation.start()
    }

    override fun onAnimationRepeat(animation: Animator?) {}

    override fun onAnimationCancel(animation: Animator?) {}

    override fun onAnimationStart(animation: Animator?) {}

    override fun onAnimationEnd(animation: Animator?) {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}