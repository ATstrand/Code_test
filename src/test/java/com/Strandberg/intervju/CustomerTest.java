package com.Strandberg.intervju;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    //only thing needed to be tested.
    @Test
    void getFixedMonthlyPayment() {
        Customer test1 =new Customer("Juha",1000.0,5.0,2);

        System.out.println(test1.getTextoutput());


        assertTrue(test1.getMonpay()==52.5, "The monthly payment should be 52.5");
    }
}