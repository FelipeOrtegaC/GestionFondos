package com.gestionfondos.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gestionfondos.Model.Product
import com.gestionfondos.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class InventoryActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)
        val movementbtn : Button = findViewById(R.id.button6)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val managbtn : ImageButton = findViewById(R.id.imageButton8)
        val homebtn : ImageButton = findViewById(R.id.imageButton9)
        val confbtn : ImageButton = findViewById(R.id.imageButton11)
        val btnProd : Button = findViewById(R.id.button5)

        btnProd.setOnClickListener {
            val tableLayout: TableLayout = findViewById(R.id.TablitaProd)

            // Ejemplo de datos
            val data = listOf(
                Pair("manzana", "10.2"),
                Pair("naranjas", "5.98"),
                Pair("peras", "37.2")
            )

            // Llenar dinámicamente el TableRow con datos
            for (pair in data) {
                val tableRow = TableRow(this)

                val textView1 = TextView(this)
                textView1.text = pair.first
                textView1.setPadding(8, 8, 8, 8)

                val textView2 = TextView(this)
                textView2.text = pair.second
                textView2.setPadding(8, 8, 8, 8)

                // Agregar TextViews al TableRow
                tableRow.addView(textView1)
                tableRow.addView(textView2)

                // Agregar TableRow al TableLayout
                tableLayout.addView(tableRow)
            }

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
            val intent: Intent = Intent(this, MovementsActivity::class.java)
            startActivity(intent)
        }
    }

    fun getProducts(callback: (List<Product>) -> Unit) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val productList = mutableListOf<Product>()

                for (productSnapshot in snapshot.children) {
                    val product = productSnapshot.getValue(Product::class.java)
                    product?.let {
                        productList.add(it)
                    }
                }

                callback(productList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejo de errores
            }
        })
    }
}