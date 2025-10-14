package com.example.factorial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numero: EditText = findViewById(R.id.editTextText)
        val textoResultado: TextView = findViewById(R.id.textView)
        val boton: Button = findViewById(R.id.button)

        boton.setOnClickListener {
            val numeroResultado = numero.text.toString().toIntOrNull()
            if (numeroResultado != null) {
                textoResultado.text = factorial(numeroResultado).toString()
            } else {
                textoResultado.text = "Introduce un valor válido"
            }
        }
    }

    private fun factorial(numero: Int): Int {
        var resultado = 1
        for (i in 1..numero) {
            resultado *= i
        }
        return resultado
    }
}
