package com.Strandberg.intervju;


public class Customer {

    private String Name;
    private Double Total_loan=0.00,Interest,monpay;
    private int Years;


    public Customer(String name, Double total_loan, Double interest, int years) {
        Name = name;
        Total_loan = total_loan;
        Interest = interest/100;
        Years = years;
        monpay = getFixedMonthlyPayment();

    }
    public String getTextoutput(){
        return Name+" wants to borrow "+Total_loan+" € for a period of "+Years+" years and pay "+monpay+" € each month";
    }
    private Double getFixedMonthlyPayment(){
        //E = Fixed monthly payment
        //b = Interest on a monthly basis
        //U = Total loan
        //p = Number of payments
        //E = U[b(1 + b)^p]/[(1 + b)^p - 1]
        Double p = Double.valueOf(Years)*12;
        Double E =Total_loan*Interest* power((1 + Interest),p)/power((1 + Interest),(p - 1));
        // rounding without math to 2 dec
        E = E *1000;
        int e= E.intValue();
        int mod_e =(e % 10);
        if (mod_e>=5){
            e=e+(10-mod_e);
        }else{
            e=e-(mod_e);
        }
        E = Double.valueOf(e) /1000;
        return E;
    }

    public Double getMonpay() {
        return monpay;
    }

    public static double power(double value, double p) {
        if (p <= 0)
            return 1;

        return value * power(value, p - 1);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getTotal_loan() {
        return Total_loan;
    }

    public void setTotal_loan(Double total_loan) {
        Total_loan = total_loan;
    }

    public Double getInterest() {
        return Interest;
    }

    public void setInterest(Double interest) {
        Interest = interest;
    }

    public int getYears() {
        return Years;
    }

    public void setYears(int years) {
        Years = years;
    }
}
