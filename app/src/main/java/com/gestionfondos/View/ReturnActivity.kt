package com.gestionfondos.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ReturnActivity: AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        val rtnhome: ImageButton = findViewById(R.id.returnButton)
        val succesfulbtn: Button = findViewById(R.id.succesfulButton)

        database = Firebase.database.reference

        rtnhome.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        succesfulbtn.setOnClickListener{
            val intent: Intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }
    }
}