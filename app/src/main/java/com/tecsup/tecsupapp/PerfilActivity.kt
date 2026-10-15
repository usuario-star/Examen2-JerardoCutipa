package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val toolbar = findViewById<Toolbar>(R.id.toolbarPerfil)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        findViewById<LinearLayout>(R.id.optionInformacion).setOnClickListener {
            Toast.makeText(this, "Información seleccionada", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.optionNotificaciones).setOnClickListener {
            Toast.makeText(this, "Notificaciones seleccionadas", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.optionFavoritos).setOnClickListener {
            Toast.makeText(this, "Favoritos seleccionados", Toast.LENGTH_SHORT).show()
        }

        val btnCerrarSesion = findViewById<MaterialButton>(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_message -> {
                Toast.makeText(this, "Mensajes", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_privacidad -> {
                startActivity(Intent(this, PrivacidadActivity::class.java))
                true
            }
            R.id.action_contactos -> {
                startActivity(Intent(this, ContactosActivity::class.java))
                true
            }
            R.id.action_central -> {
                Toast.makeText(this, "Central de Ayuda: +51 1 987987987", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
