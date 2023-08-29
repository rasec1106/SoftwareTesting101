package pe.edu.cibertec;

public class Calculadora {
    public static int sumar(int n1, int n2){
        return n1+n2;
    }
    public static int restar(int n1, int n2){
        return n1-n2;
    }
    public static int multiplicar(int n1, int n2){
        return n1*n2;
    }
    public static double dividir(int n1, int n2) throws ArithmeticException{
        try{
            return (n1 * 1.0)/n2;
        }catch (ArithmeticException ex){
            System.out.println("Division by zero");
            throw ex;
        }
    }
}
