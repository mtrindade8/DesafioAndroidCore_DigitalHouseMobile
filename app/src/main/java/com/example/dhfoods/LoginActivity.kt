package com.example.dhfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.btnRegister

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            callHomeActivity()
        }

        btnRegister.setOnClickListener{
            callRegisterActiviy()
        }

    }

    fun callHomeActivity(){
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun callRegisterActiviy(){
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}
