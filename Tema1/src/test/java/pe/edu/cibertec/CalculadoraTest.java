package pe.edu.cibertec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    public void sumarPositivos() {
        System.out.println("Sumando dos numeros positivos");
        assertEquals(9, Calculadora.sumar(4,5));
    }
    public void sumarNegativos() {
        System.out.println("Sumando dos numeros negativos");
        assertEquals(-9, Calculadora.sumar(-4,-5));
    }

    @Test
    public void restar() {
        assertTrue(Calculadora.restar(3,4) == -1);
    }

    @Test
    public void multiplicar() {
        assertTrue(Calculadora.multiplicar(3,8) == 24);
    }
    
    @Test
    public void multiplicarPorMenos1(){
        assertFalse(Calculadora.multiplicar(3,-1) == 3);
    }

    @Test
    public void dividir() {
        assertEquals(0.5,Calculadora.dividir(1,2));
    }

    @Test
    public void dividirPorCero() {
        try{
            Calculadora.dividir(10,0);
        }catch (Exception ex){
            assertTrue(ex instanceof ArithmeticException);
        }

    }
}