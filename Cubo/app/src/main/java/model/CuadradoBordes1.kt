package model

import android.graphics.Color

class CuadradoBordes1 (color:Int, ancho:Int, alto:Int, var bordeColor:Int= Color.BLACK):
    //por defecto todas las clases son final, por tanto no pueden heredar, le ponemos open
    Cuadrado(color,ancho,alto){
        //metodo nuevo cambiarColorBorde
        fun cambiarColorBorde(nuevoColorBorde: Int){
            bordeColor = nuevoColorBorde
        }



}