package com.gestionfondos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class StartActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val metrics : ImageButton = findViewById(R.id.imageButton7)
        val manag : ImageButton = findViewById(R.id.imageButton8)
        val inv : ImageButton = findViewById(R.id.imageButton10)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)

        metrics.setOnClickListener{
            val intent: Intent = Intent(this, MetricsActivity::class.java)
            startActivity(intent)
         }

        manag.setOnClickListener{
            val intent: Intent = Intent(this, ManagementActivity::class.java)
            startActivity(intent)
        }

       inv.setOnClickListener{
           val intent: Intent = Intent(this, InventoryActivity::class.java)
           startActivity(intent)
       }
        confbtn.setOnClickListener {
           val intent: Intent = Intent(this, ConfigActivity::class.java)
           startActivity(intent)
       }

        }
}