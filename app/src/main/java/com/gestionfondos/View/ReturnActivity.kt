package com.gestionfondos.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.Model.UserData
import com.gestionfondos.R
import com.gestionfondos.ViewModel.controlFirebaseAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ReturnActivity: AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        val rtnhome: ImageButton = findViewById(R.id.returnButton)
        val succesfulbtn: Button = findViewById(R.id.succesfulButton)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Users")

        val txt : EditText = findViewById(R.id.editTextText3)
        val txt2 : EditText = findViewById(R.id.editTextText4)
        val txt3 : EditText = findViewById(R.id.editTextText5)
        val txt4 : EditText = findViewById(R.id.editTextText6)



        rtnhome.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        succesfulbtn.setOnClickListener{
            var Username :String = txt.text.toString()
            var correo : String = txt2.text.toString()
            var Password: String = txt3.text.toString()
            var Password2 : String = txt4.text.toString()

            if (Password == Password2){

                if (Username.isNotEmpty() && Password.isNotEmpty()){

                    signUpUser(Username,  correo, Password)

                }else{
                    Toast.makeText(this@ReturnActivity, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this@ReturnActivity, "La contraseña no concuerda", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun signUpUser(username: String, correo: String, password: String){
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()){
                    val id = databaseReference.push().key
                    val userData = UserData(id, username, correo, password)
                    databaseReference.child(id!!).setValue(userData)
                    Toast.makeText(this@ReturnActivity, "Registro, Completado!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@ReturnActivity, MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this@ReturnActivity, "Usuario ya existe", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ReturnActivity, "Error en la base de datos: ${error.message}", Toast.LENGTH_SHORT).show()

            }
        })
    }
}