package com.gestionfondos.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.Model.Product
import com.gestionfondos.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MovementsActivity: AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movement)
        val movementbtn : Button = findViewById(R.id.button5)
        val btnIngreso : Button = findViewById(R.id.button8)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val managbtn : ImageButton = findViewById(R.id.imageButton8)
        val homebtn : ImageButton = findViewById(R.id.imageButton9)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)



        btnIngreso.setOnClickListener{
            var newProduct = Product("123", "Naranjas", 10.99, 50)
            insertProductForUser(newProduct)
            newProduct = Product("223", "Manzanas", 70.99, 90)
            insertProductForUser(newProduct)
            newProduct = Product("133", "Nuevo Peras", 50.99, 70)
            insertProductForUser(newProduct)
        }

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
        movementbtn.setOnClickListener{
            val intent: Intent = Intent(this, InventoryActivity::class.java)
            startActivity(intent)
        }
    }

    fun insertProductForUser(product: Product) {
        val userProductReference = databaseReference.child("Products")
        val productKey = userProductReference.push().key
        productKey?.let {
            userProductReference.child(it).setValue(product)
        }
    }

}