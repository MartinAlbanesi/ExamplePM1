package com.example.examplepm1.ui.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examplepm1.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuración de la barra de insets para que se adapte a los cambios de tamaño de la pantalla
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración de los botones de navegación inferior
        setupThemeChangeButton()
        setupBottomNavigation()
    }

    // Configuración del botón para cambiar el tema
    private fun setupThemeChangeButton() {
        val themeChangeButton: FloatingActionButton = findViewById(R.id.theme_change_button)

        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        val isNightMode = currentNightMode == Configuration.UI_MODE_NIGHT_YES

        if (isNightMode) {
            themeChangeButton.setImageResource(R.drawable.ic_sun)
        } else {
            themeChangeButton.setImageResource(R.drawable.ic_moon)
        }

        themeChangeButton.setOnClickListener {
            val nightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            if (nightMode == Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    // Configuración de la navegación inferior
    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.navigation_main

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_screen1 -> {
                    val intent = Intent(this, Screen1Activity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.navigation_main -> {
                    true
                }

                R.id.navigation_screen2 -> {
                    val intent = Intent(this, Screen2Activity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}
