package com.example.firebase_authentication_app_tk4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    //Variables
    lateinit var btnLog : Button
    lateinit var edEmails : EditText
    lateinit var edPasswords : EditText

    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //typecast
        btnLog = findViewById(R.id.btnLogin)
        edEmails = findViewById(R.id.edEmail)
        edPasswords = findViewById(R.id.edPassword)
        auth = FirebaseAuth.getInstance()


        //Initialize FireBase
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()

        //method
        btnLog.setOnClickListener{

            val email = edEmails.text.toString().trim()
            val password = edPasswords.text.toString().trim()

            //checks
            if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this, "Email or password incorrect", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }//end_if

            loginUser(email,password)

        }//listener_end

    }//end_OnCreate


    //method
    fun loginUser(email:String, password:String)
    {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {task ->
                if(task.isSuccessful)
                {
                    Toast.makeText(this, "TK You are now logged in", Toast.LENGTH_SHORT).show()
                }else
                {
                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                }
            }

    }//end_Fun

}