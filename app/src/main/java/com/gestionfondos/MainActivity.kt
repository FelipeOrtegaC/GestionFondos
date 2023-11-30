package com.gestionfondos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

//TEMAS DE LOGICA
//Por temas de espacio en el mainactivity/plaintext es necesario
//que el usuario y contraseña no superen los 8 digitos
//El tamaño de los elementos textbox y boton es de 515*60px

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button3)
        val rtn: Button = findViewById(R.id.button4)

        btn.setOnClickListener {
            val intent: Intent = Intent(this, StartActivity::class.java)

            startActivity(intent)
        }
        rtn.setOnClickListener{
            val intent: Intent = Intent(this, ReturnActivity::class.java)
            startActivity(intent)
        }
    }
}