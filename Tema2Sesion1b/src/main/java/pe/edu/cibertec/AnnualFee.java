package pe.edu.cibertec;

public class AnnualFee {
    public static final double UIT = 4950;
    private static final double fee1 = 0.08;
    private static final double fee2 = 0.14;
    private static final double fee3 = 0.17;
    private static final double fee4 = 0.2;
    private static final double fee5 = 0.3;

    public static double calculateFee(double amount){
        if(amount < 7*UIT) return 0;
        if(amount < 12*UIT) return fee1*amount;
        return fee1*12*UIT + fee2*(amount-(12*UIT));
    }

}
