import kotlin.math.PI

fun main(){
    println("Olá para realização do calculo por favor informar o diametro:")
    val diametro = readln()!!.toDouble()

    val raio = diametro / 2
    val perimetro = 2 * PI * raio
    val area = PI * Math.pow(raio,2.0)

    println("Perimetro: $perimetro")
    println("Area: $area")

}