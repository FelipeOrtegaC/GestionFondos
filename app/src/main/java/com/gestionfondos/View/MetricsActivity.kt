package com.gestionfondos.View

import android.os.Bundle
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.R


class MetricsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrics)
        val managbtn : ImageButton = findViewById(R.id.imageButton8)
        val homebtn : ImageButton = findViewById(R.id.imageButton9)
        val inv : ImageButton = findViewById(R.id.imageButton10)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)
        managbtn.setOnClickListener{
            val intent: Intent = Intent(this, ManagementActivity::class.java)
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
        val dropdown = findViewById<Spinner>(R.id.spinner)
        val items = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter

    }
}