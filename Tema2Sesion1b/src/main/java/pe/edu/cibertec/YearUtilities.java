package pe.edu.cibertec;

public class YearUtilities {
    public static boolean isLeap(int year){
        return (year%4==0 && year%100!=0) || year%400==0;
    }
}
