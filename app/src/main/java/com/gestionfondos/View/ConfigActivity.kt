package com.gestionfondos.View

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.gestionfondos.R
import java.util.Locale

class ConfigActivity: AppCompatActivity() {

    private val CHANNEL_ID = "my_channel_id"
    private val notificationId = 101

    private lateinit var switch: Switch
    private lateinit var txtnot: Button
    private lateinit var txtabout: Button
    private lateinit var txtclose: Button
    private lateinit var txtlang: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        val metricbtn: ImageButton = findViewById(R.id.imageButton7)
        val managbtn: ImageButton = findViewById(R.id.imageButton8)
        val homebtn: ImageButton = findViewById(R.id.imageButton9)
        val invbtn: ImageButton = findViewById(R.id.imageButton10)
        switch = findViewById(R.id.switchLang)
        txtlang = findViewById(R.id.button)
        txtnot = findViewById(R.id.button2)
        txtabout = findViewById(R.id.button3)
        txtclose = findViewById(R.id.button4)

        createNotificationChannel()

        txtnot.setOnClickListener()
        {
            sendNotification()
        }

        txtclose.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
        invbtn.setOnClickListener {
            val intent: Intent = Intent(this, InventoryActivity::class.java)
            startActivity(intent)
        }
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "CHANGE TO ES", Toast.LENGTH_SHORT).show()
                actualizarResource("es")
            } else {
                Toast.makeText(this, "CAMBIO A EN", Toast.LENGTH_SHORT).show()
                actualizarResource("en")
            }
        }
    }

    fun actualizarResource(idioma: String) {

        val recursos = resources
        val displayMetrics = recursos.displayMetrics
        val configuracion = resources.configuration
        configuracion.setLocale(Locale(idioma))
        recursos.updateConfiguration(configuracion, displayMetrics)
        configuracion.locale = Locale(idioma)
        resources.updateConfiguration(configuracion, displayMetrics)
        txtnot.text = recursos.getString(R.string.configalert)
        txtabout.text = recursos.getString(R.string.configinfo)
        txtclose.text = recursos.getString(R.string.configclose)
        txtlang.text = recursos.getString(R.string.configlang)
    }

    private fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description=descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(){
        val intent = Intent(this, ConfigActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_IMMUTABLE)

        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,
            R.drawable.notifimage
        )
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources,
            R.drawable.logo
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.channel_name))
            .setContentText(getString(R.string.channel_description))
            .setLargeIcon(bitmapLargeIcon)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this@ConfigActivity))
        {
            if (ActivityCompat.checkSelfPermission(
                    this@ConfigActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(notificationId, builder.build())
        }
    }


}