package com.tecsup.tecsupapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        val toolbar = findViewById<Toolbar>(R.id.toolbarContactos)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val contactos = arrayOf(
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987"
        )

        val lvContactos = findViewById<ListView>(R.id.lvContactos)
        val adapter = ArrayAdapter(this, R.layout.item_contacto, R.id.tvContacto, contactos)
        lvContactos.adapter = adapter

        // Al hacer click en un contacto, mostrar PopupMenu (Llamar / Enviar mensaje)
        lvContactos.setOnItemClickListener { _, view, position, _ ->
            showContactoPopup(view, contactos[position])
        }
    }

    private fun showContactoPopup(view: View, contactoInfo: String) {
        val popup = PopupMenu(this, view)
        popup.menu.add("Llamar")
        popup.menu.add("Enviar mensaje")

        popup.setOnMenuItemClickListener { item ->
            when (item.title) {
                "Llamar" -> {
                    Toast.makeText(this, "Llamando a $contactoInfo", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+511987987987"))
                    startActivity(intent)
                    true
                }
                "Enviar mensaje" -> {
                    Toast.makeText(this, "Enviando mensaje a $contactoInfo", Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+511987987987"))
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_simple_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_privacidad -> {
                startActivity(Intent(this, PrivacidadActivity::class.java))
                finish()
                true
            }
            R.id.action_contactos -> {
                // Ya estamos en Contactos
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
