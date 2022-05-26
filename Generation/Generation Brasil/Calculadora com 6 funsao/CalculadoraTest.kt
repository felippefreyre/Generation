import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.expect

internal class CalculadoraTest{
  @Test
  fun somaTest(){
      assertEquals(6, Calculadora.soma(3,3))
  }
   @Test
    fun subtraçaoTest(){
        assertEquals(3, Calculadora.subtraçao(5,2))
   }
    @Test
    fun divisãoTest(){
        assertEquals(3, Calculadora.divisão(9,3) )
    }
    @Test
    fun multiplicacaoTest(){
        assertEquals(18, Calculadora.multiplicacao(6,3))
    }
    @Test
    fun porcentagemTest(){
        assertEquals(20.0, Calculadora.porcentagem(40.0,50.0))
    }
    @Test
    fun raizTest(){
        assertEquals(5.0, Calculadora.raiz(25.0))

    }
}
