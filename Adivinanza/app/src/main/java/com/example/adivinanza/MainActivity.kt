package com.example.adivinanza

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.example.adivinanza.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val numeroIntroducido : EditText = findViewById(R.id.entradaValor)
        val boton : Button = findViewById(R.id.button2)
        val mensajeSalida : TextView = findViewById(R.id.salidaValor)
        val numeroAleatorio = Random.nextInt(1, 101)
        var contador : Int = 0

        boton.setOnClickListener {
            contador++
            //recogemos el valor
            val valorIntroducido = numeroIntroducido.text.toString().toIntOrNull()
            if (valorIntroducido == null) mensajeSalida.text="Debe introducir un valor"
            else if (numeroAleatorio < valorIntroducido) mensajeSalida.text="Más bajo"
            else if (numeroAleatorio > valorIntroducido) mensajeSalida.text="Más Alto"
            else mensajeSalida.text="numero correcto. Has usado $contador intentos"
        }
    }
}