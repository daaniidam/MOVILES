package model

open class Cuadrado(var color:Int, var ancho:Int, var alto:Int) {
    //Coordenada iniciales
    var x: Int=0
    var y: Int=0
    //metodos para mover-cambiar el cuadrado
    fun moverArriba(){
        y = y-50
    }
    fun moverAbajo(){
        y = y+50
    }
    fun moverIzquierda(){
        x = x-50
    }
    fun moverDerecha(){
        x = x+50
    }

    fun CambiarTamanio(ancho:Int,alto:Int){
        this.ancho = ancho
        this.alto = alto
    }

    fun aumentarTamanio(incremento: Int) {
        this.ancho += incremento
        this.alto += incremento
    }
    fun disminuirTamanio(descenso: Int) {
        this.ancho -= descenso
        this.alto -= descenso
    }

}