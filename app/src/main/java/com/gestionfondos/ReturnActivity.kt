package com.gestionfondos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ReturnActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        val rtnhome: ImageButton = findViewById(R.id.returnButton)
        val succesfulbtn: Button = findViewById(R.id.succesfulButton)
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