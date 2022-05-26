import kotlin.math.pow
import kotlin.math.sqrt

class Calculadora {

    companion object {
        fun soma(x1: Int, x2: Int): Int {
            return x1 + x2
        }

        fun subtraçao(x1: Int, x2: Int): Int {
            return x1 - x2
        }

        fun divisão(x1: Int, x2: Int): Int {
            return x1 / x2
        }

        fun multiplicacao(x1: Int, x2: Int): Int {
            return x1 * x2
        }

        fun porcentagem(x1: Double, x2: Double): Double {
            return x1 * (x2 / 100)
        }
        fun raiz(x1: Double): Double = sqrt(x1)
        }

    }






