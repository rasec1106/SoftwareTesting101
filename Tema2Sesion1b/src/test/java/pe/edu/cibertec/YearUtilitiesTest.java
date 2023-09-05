package pe.edu.cibertec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YearUtilitiesTest {
    
    @Test
    public void test1() {
        assertTrue(YearUtilities.isLeap(4)); // is Leap
    }
    @Test
    public void test2() {
        assertFalse(YearUtilities.isLeap(6));// is NOT Leap
    }
    @Test
    public void test3() {
        assertFalse(YearUtilities.isLeap(100));// is NOT Leap
    }
    @Test
    public void test4() {
        assertTrue(YearUtilities.isLeap(400));// is Leap
    }
    @Test
    public void test5() {
        assertFalse(YearUtilities.isLeap(2015));// is NOT Leap
    }
    @Test
    public void test6() {
        assertTrue(YearUtilities.isLeap(2016));// is Leap
    }
}