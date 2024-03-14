package com.example.firebase_authentication_app_tk4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {

    //VARIABLES
    lateinit var edUsername : EditText
    lateinit var edEmailReg : EditText
    lateinit var edPasswordReg : EditText
    lateinit var edConfirmPasswordReg : EditText

    lateinit var mAuth :FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        //TypeCasting
        edUsername = findViewById(R.id.edUsername)
        edEmailReg = findViewById(R.id.edEmails)
        edPasswordReg = findViewById(R.id.edPasswordReg)
        edConfirmPasswordReg = findViewById(R.id.edPasswordReg2)
        mAuth = FirebaseAuth.getInstance()


    }
}