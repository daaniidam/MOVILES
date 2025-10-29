package com.example.cubo

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Cuadrado
import model.CuadradoBordes1
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //identificacion de la vista
        val cuadradoView: View= findViewById(R.id.cuadrado)
        /*usamos el metodo post para que se ejecute este bloque de codigo en el hilo de la interfaz de usuario justo despues
        de que se cargue la vista, se construye y se mida

         */
        //variables que recogen los datos de la view inicial
        cuadradoView.post {
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX: Int = cuadradoView.x.toInt()
            val inicialY: Int = cuadradoView.y.toInt()
            //asociar la vista con el objeto cuadrado
            //ContextCompat es una clase para acceder a recursos
            /*val cuadrado: Cuadrado = Cuadrado(ContextCompat.getColor(this, R.color.red), inicialAncho, inicialAlto).apply {
                //damos los valores de x e y de la vista
                x = inicialX
                y = inicialY
            }
            */

            val cuadrado: CuadradoBordes1 = CuadradoBordes1(ContextCompat.getColor(this, R.color.red), inicialAncho, inicialAlto, ContextCompat.getColor(this, R.color.black)).apply {
                //damos los valores de x e y de la vista
                x = inicialX
                y = inicialY
            }
            /*val cuadrado: CuadradoBordes1 = CuadradoBordes1(ContextCompat.getColor(this, R.color.red), inicialAncho, inicialAlto, ContextCompat.getColor(this, R.color.black)).apply {
                //damos los valores de x e y de la vista
                x = inicialX
                y = inicialY
                bordeColor = ContextCompat.getColor(this@MainActivity, R.color.black)
            }
            */
            //identificacion de botones
            val botonArriba: Button = findViewById(R.id.buttonArriba)
            val botonAbajo: Button = findViewById(R.id.buttonAbajo)
            val botonIquierda: Button = findViewById(R.id.buttonIzquierda)
            val botonDerecha: Button = findViewById(R.id.buttonDerecha)
            val botonAumentarTamanio: Button = findViewById(R.id.buttonAumentarTamanio)
            val botonDisminuirTamanio: Button = findViewById(R.id.buttonDisminuirTamanio)
            val botonCambiarColor: Button = findViewById(R.id.buttonCambiarColor)
            val botonColorBorde: Button = findViewById(R.id.buttonCambiarColorBorde)
            //ponemos botones a la escucha
            botonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonIquierda.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonAumentarTamanio.setOnClickListener {
                cuadrado.aumentarTamanio(50)
                actualizarVista(cuadrado, cuadradoView)
            }
            botonDisminuirTamanio.setOnClickListener {
                cuadrado.disminuirTamanio(50)
                actualizarVista(cuadrado, cuadradoView)
            }
            botonCambiarColor.setOnClickListener {
                //cuadrado.color = ContextCompat.getColor(this, R.color.blue)
                cuadrado.color = generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonColorBorde.setOnClickListener {
                cuadrado.cambiarColorBorde(generarColorAleatorio())
                actualizarVista(cuadrado, cuadradoView)
            }
        }//post
    }
    fun generarColorAleatorio(): Int{
        //generar 3 numeros aleatorios R,G,B entre 0 y 255 incluido
        //creamos una variable random con random default
        val random = Random.Default
        val rojo=random.nextInt(256)
        val verde=random.nextInt(256)
        val azul=random.nextInt(256)
        //Color es la clase para alamacenar colores y el metodo rgb() saca el numero
        return Color.rgb(rojo,verde,azul)
    }
    private fun actualizarVista(cuadrado: CuadradoBordes1,cuadradoView: View){
        //Aqui es donde enlazamos la vista con el objeto
        //la vista actualizara su ancho y alto con los datos del objeto
        cuadradoView.layoutParams.width=cuadrado.ancho
        cuadradoView.layoutParams.height=cuadrado.alto
        //cambiamos el color
        cuadradoView.setBackgroundColor(cuadrado.color)
        //actualizar coordenadas
        cuadradoView.x = cuadrado.x.toFloat()
        cuadradoView.y = cuadrado.y.toFloat()
        //cambiamos rl color del fondo y del borde. Todo ello lo tenemos en una clase de kotlin GradientDrawable
        val drawable: GradientDrawable = GradientDrawable()
        drawable.setColor(cuadrado.color)
        drawable.setStroke(10, cuadrado.bordeColor)
        cuadradoView.background = drawable
        //ejecutar los cambios
        cuadradoView.requestLayout()
    }

}


//MVVM
//model-datos
//view-layout --> es la vista en este caso ya est ahecha con xml
//view-model --> seria la logica entre el modelo y la vista, es decir que lo reclaman