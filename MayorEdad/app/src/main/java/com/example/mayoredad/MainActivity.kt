package com.example.mayoredad

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
import com.example.mayoredad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numero : EditText = findViewById<EditText>(R.id.editTextText)
        val boton : Button = findViewById<Button>(R.id.button)
        val texto : TextView = findViewById<TextView>(R.id.textView2)
        val menos : Button = findViewById(R.id.menos)
        val mas : Button = findViewById(R.id.mas)
/*boton.setOnClickListener {
    //recoger el valor del campo texto, tendremos que pasarlo a entero
    val numeroRes = numero.text.toString().toIntOrNull()
    /*if (numeroRes == null)
        texto.text="Debe introducir un numero obligatoriamente"
    else if (numeroRes < 18 )
        texto.text= "Eres menor de edad"
    else if (numeroRes > 18)
        texto.text = "Eres maypr de edad"
    else texto.text = "Tienes justo 18 años"

    texto.text = if (numeroRes == null) "Introduzca un valor"
    else if (numeroRes < 18)"Eres menor de edad"
    else if (numeroRes > 18)"Eres mayor de edad"
    else "Tienes justo 18 años"
    */
}*/
        fun verificarEdad(valor: Int?) {
            texto.text = when {
                valor == null -> "Introduzca un valor"
                valor < 18 -> "Eres menor de edad"
                valor > 18 -> "Eres mayor de edad"
                else -> "Tienes justo 18 años"
            }
        }
        boton.setOnClickListener {
            val numeroRes = numero.text.toString().toIntOrNull()
            verificarEdad(numeroRes)
        }
        // Botón para restar y verificar
        menos.setOnClickListener {
            val valorActual = numero.text.toString().toIntOrNull() ?: 0
            val nuevoValor = if (valorActual > 0) valorActual - 1 else 0
            numero.setText(nuevoValor.toString())
            verificarEdad(nuevoValor)
        }

        // Botón para sumar y verificar
        mas.setOnClickListener {
            val valorActual = numero.text.toString().toIntOrNull() ?: 0
            val nuevoValor = valorActual + 1
            numero.setText(nuevoValor.toString())
            verificarEdad(nuevoValor)
        }
    }

}