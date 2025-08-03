package org.Week4;

public class CalculatePow {
    public double myPow(double x, int n) {
        long power = n;
        if(power <0){
            x = 1/x;
            power = -power;
        }
        return calculatePower(x, power);
    }
    private double calculatePower(double x, long n){
        if (n == 0){
            return 1;
        }

        if (x == 0){
            return 0;
        }

        if(n % 2 == 0){
            return calculatePower(x*x, n/2); //recursion
        }
        else {
            return x* calculatePower(x*x, (n-1)/2); //recursion
        }
    }
    // doing with iteration
    public double myPow1(double x, int n) {
        long power = n;
        if(power <0){
            x = 1/x;
            power = -power;
        }
        double result = 1.0; // as anything to the power 0 is 1
        while(power>0){
            if(power%2 == 1){ // odd condition
                result = result * x; //extra x we have to multiply
            }
            x = x*x; // double the base
            power = power/2; //half the exponent
        }
        return result;
    }
}
