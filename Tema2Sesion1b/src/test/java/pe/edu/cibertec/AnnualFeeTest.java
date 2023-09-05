package pe.edu.cibertec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnnualFeeTest {
    private double tier0 = 0;
    private double tier1 = 7*AnnualFee.UIT;
    private double tier2 = 12*AnnualFee.UIT;
    private double tier3 = 27*AnnualFee.UIT;
    private double tier4 = 42*AnnualFee.UIT;
    private double tier5 = 52*AnnualFee.UIT;

    @Test
    public void test01(){
        double fee = AnnualFee.calculateFee(tier1 - 1);
        assertEquals(0,fee);
    }
    @Test
    public void test02(){
        double fee = AnnualFee.calculateFee(tier1);
        assertEquals(2772,fee);
    }
    @Test
    public void test03(){
        double fee = AnnualFee.calculateFee(74250);
        assertEquals(6831,fee);
    }

//    monto final = 74250
//    12uit = 59400 --> 4752
//    restante = 14859 --> 2079



}