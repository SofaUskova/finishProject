package com.example.finishproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_registration.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}