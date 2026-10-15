package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val toolbar = findViewById<Toolbar>(R.id.toolbarNoticias)
        setSupportActionBar(toolbar)

        val btnProfile = findViewById<ImageView>(R.id.btnProfile)
        btnProfile?.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        val fabShare = findViewById<FloatingActionButton>(R.id.fabShare)
        fabShare.setOnClickListener {
            val shareDialog = ShareBottomSheetDialogFragment()
            shareDialog.show(supportFragmentManager, "ShareBottomSheet")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_noticias, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, PerfilActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
