package com.gestionfondos.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gestionfondos.Model.UserData
import com.gestionfondos.R
import com.gestionfondos.ViewModel.controlFirebaseAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

//TEMAS DE LOGICA
//Por temas de espacio en el mainactivity/plaintext es necesario
//que el usuario y contraseña no superen los 8 digitos
//El tamaño de los elementos textbox y boton es de 515*60px

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button3)
        val rtn: Button = findViewById(R.id.button4)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Users")

        val txt : EditText = findViewById(R.id.editTextText)
        val txt2 : EditText = findViewById(R.id.editTextText2)

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