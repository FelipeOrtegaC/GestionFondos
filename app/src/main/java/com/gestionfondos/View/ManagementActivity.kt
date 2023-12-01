package com.gestionfondos.View

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.R

class ManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_management)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val homebtn: ImageButton = findViewById(R.id.imageButton9)
        val inv: ImageButton = findViewById(R.id.imageButton10)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)
        metricbtn.setOnClickListener{
            val intent: Intent = Intent(this, MetricsActivity::class.java)
            startActivity(intent)
        }
        homebtn.setOnClickListener{
            val intent: Intent = Intent(this, StartActivity::class.java)
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