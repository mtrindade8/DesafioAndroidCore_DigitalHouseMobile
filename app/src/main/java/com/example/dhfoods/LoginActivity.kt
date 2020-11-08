package com.example.dhfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegister.setOnClickListener{
            callRegisterActiviy()
        }

    }

    fun callRegisterActiviy(){
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}
