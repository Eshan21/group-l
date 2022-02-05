package com.groupl.controllers.jonathanabout;

import java.util.ArrayList;

public class ExperimentalFarm {
    private ArrayList<Plot>[] farmPlots;

    public ExperimentalFarm(ArrayList<Plot>[] farmPlots) {
        this.farmPlots = farmPlots;
    }

    public String getHighestYield(String c) {
        System.out.println("Running getHighestYield(" + c + ")");
        int max_yield = 0;
        Plot max_plot = null;

        int x = -1;
        int y = -1;
        for (ArrayList<Plot> plots : farmPlots) {
            for (Plot plot : plots) {
                System.out.println(c + ".equals(" + plot.getCrop() + ")");
                if (c.equals(plot.getCrop())) {
                    System.out.println(plot.getYield() + " > " + max_yield);
                    if (plot.getYield() > max_yield) {
                        max_yield = plot.getYield();
                        max_plot = plot;
                        System.out.println("max = " + max_yield);
                    }
                }
                y++;
            }

            x++;
        }

        return String.format("Plot[%d][%d]", x, y);
    }

    public boolean sameCrop(int col) {
        System.out.println("Running sameCrop");
        String exp_crop = farmPlots[0].get(0).getCrop();
        System.out.println("col num: " + col);
        System.out.println("exp_crop: " + exp_crop);

        for (ArrayList<Plot> plot : farmPlots) {
            System.out.println("Next crop: " + plot.get(col).getCrop());
            if (!plot.get(col).getCrop().equals(exp_crop)) {
                return false;
            }
        }

        return true;
    }
}

