package com.gestionfondos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val managbtn : ImageButton = findViewById(R.id.imageButton8)
        val homebtn : ImageButton = findViewById(R.id.imageButton9)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)
        metricbtn.setOnClickListener {
            val intent: Intent = Intent(this, MetricsActivity::class.java)
            startActivity(intent)
        }
        managbtn.setOnClickListener {
            val intent: Intent = Intent(this, ManagementActivity::class.java)
            startActivity(intent)
        }
        homebtn.setOnClickListener {
            val intent: Intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }
        confbtn.setOnClickListener {
            val intent: Intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }
    }
}