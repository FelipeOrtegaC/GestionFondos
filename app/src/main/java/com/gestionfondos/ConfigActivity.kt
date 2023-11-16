package com.gestionfondos

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class ConfigActivity: AppCompatActivity() {

    private lateinit var switch : Switch
    private lateinit var txtnot : Button
    private lateinit var txtabout : Button
    private lateinit var txtclose : Button
    private lateinit var txtlang : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val managbtn : ImageButton = findViewById(R.id.imageButton8)
        val homebtn : ImageButton = findViewById(R.id.imageButton9)
        val invbtn : ImageButton = findViewById(R.id.imageButton10)
        switch = findViewById(R.id.switchLang)
        txtlang = findViewById(R.id.button)
        txtnot = findViewById(R.id.button2)
        txtabout = findViewById(R.id.button3)
        txtclose = findViewById(R.id.button4)
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
        invbtn.setOnClickListener {
            val intent: Intent = Intent(this, InventoryActivity::class.java)
            startActivity(intent)
        }
        switch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                Toast.makeText(this, "CHANGE TO ES", Toast.LENGTH_SHORT).show()
                actualizarResource("es")
            }
            else
            {
                Toast.makeText(this, "CAMBIO A EN", Toast.LENGTH_SHORT).show()
                actualizarResource("en")
            }
        }
    }
    fun actualizarResource(idioma: String)
    {

        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val configuracion = resources.configuration
        configuracion.setLocale(Locale(idioma))
        recursos.updateConfiguration(configuracion, displayMetrics)
        configuracion.locale =Locale(idioma)
        resources.updateConfiguration(configuracion, displayMetrics)
        txtnot.text = recursos.getString(R.string.configalert)
        txtabout.text = recursos.getString(R.string.configinfo)
        txtclose.text = recursos.getString(R.string.configclose)
        txtlang.text = recursos.getString(R.string.configlang)
    }
    }
