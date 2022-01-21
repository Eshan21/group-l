package com.groupl.controllers.jonathanabout;

public class Payroll {
    private int[] itemsSold;
    private double[] wages;

    public double[] getWages() {
        return wages;
    }

    public void setItemsSold(int[] itemsSold) {
        this.itemsSold = itemsSold;
    }

    public int[] getItemsSold() {
        return itemsSold;
    }

    public double computeBonusThreshold() {
        int max = 0;
        int min = itemsSold[0];
        int total = 0;
        
        for (int items : itemsSold) {
            if (items > max) {
                max = items;
            }

            if (items < min) {
                min = items;
            }

            total += items;
        }

        return (double) (total - max - min) / (itemsSold.length - 2);
    }

    public void computeWages(double fixedWage, double perItemWage) {
        wages = new double[itemsSold.length];
        int i = 0;
        for (int items : itemsSold) {
            boolean bonus = (double) items > computeBonusThreshold();
            wages[i] = ((fixedWage + perItemWage * items) * (bonus ? 1.1 : 1));
            i++;
        }
    }
}

