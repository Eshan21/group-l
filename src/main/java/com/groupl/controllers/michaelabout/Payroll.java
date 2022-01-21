package com.groupl.controllers.michaelabout;

public class Payroll {

    private int[] itemsSold; // number of items sold by each employee

    public double[] wages; // wages to be computed in part (b)

    /** Returns the bonus threshold as described in part (a).

    */

    public Payroll(int[] itemsSold) {

        this.itemsSold = itemsSold;

    }

    public double computeBonusThreshold() {
    /* To be implemented in part (a) */

        int biggest = itemsSold[0], smallest = itemsSold[0], currentCount = 0;

        for (int temp : itemsSold ) {
            // int temp = soldCount;
            if(biggest < temp) {
                biggest = temp;
            } else if(smallest > temp) {
                smallest = temp;
            }

            currentCount += temp;
        }

        return (double)(currentCount - biggest - smallest) / 8.0;

    }

    

    /** Computes employee wages as described in part (b)

    * and stores them in wages.

    * The parameter fixedWage represents the fixed amount each employee

    * is paid per day.

    * The parameter perItemWage represents the amount each employee

    * is paid per item sold.

    */

    public void computeWages(double fixedWage, double perItemWage) {

        /* To be implemented in part (b) */

        double threshold = this.computeBonusThreshold();
        wages = new double[itemsSold.length];

        int i = 0;
        for (int soldCount : itemsSold ) {
            wages[i] = fixedWage + fixedWage * soldCount;
            // int temp = soldCount;
            if(soldCount > threshold) {
                wages[i] *= 1.1;
            }
            i++;
        }

    }

    public static void main(String args[])  {
        int[] soldAmount= {48,50,37,62,38,70,55,37,64,60};
        Payroll pr = new Payroll(soldAmount);
        System.out.println("threshold: " + pr.computeBonusThreshold());
        pr.computeWages(10.0, 1.5);
        for(double wage : pr.wages) {
            System.out.println(wage);
        }
        
    }
    // Other instance variables, constructors, and methods not shown.
}