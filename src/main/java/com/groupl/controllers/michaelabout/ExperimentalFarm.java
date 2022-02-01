package com.groupl.controllers.michaelabout;

import java.util.ArrayList;

public class ExperimentalFarm 
{
	private Plot[][] farmPlots;

	public 
	ExperimentalFarm(Plot[][] p) 
	{
		farmPlots = p;
	}

	/** Returns the plot with the highest yield for a given crop type, ar described in part (a). */

	public Plot 
	getHighestYield(String c) 
	{
		/* to be implemented in part (a) */
		Plot highestYield = farmPlots[0][0];
		for(int i = 0; i < farmPlots.length; i++) {
			for(int j = 0; j < farmPlots[i].length; j++) {

				Plot currentPlot = farmPlots[i][j];
				if(currentPlot.getCropType().equals(c) && currentPlot.getCropYield() > highestYield.getCropYield()) {
					highestYield = currentPlot;
				}

			}
		}

		if(highestYield == null) {
			// do something			
		}
		return highestYield;	
	}


	/** Returns true if all plots in a given column in the two-dimensional array farmPlots
	 *
	 *
	 *
	 * * contain the same type of crop, or false otherwise, as described in part (b).
	 *
	 *
	 *
	 * */

	public boolean 
	sameCrop(int col) 
	{
		/* to be implemented in part (b) */

		Plot firstPlot = farmPlots[col][0];
		for(int i = 1; i < farmPlots[col].length; i++) {
			if (!firstPlot.getCropType().equals(farmPlots[col][i].getCropType())) {
				return false;
			}
		}
		return true;
	}

	public static void 
	main(String args[]) 
	{
		Plot[][] temp = {
			{
				new Plot("corn", 20),
				new Plot("peas", 30),
				new Plot("wheat", 10),
				new Plot("corn", 55)
			},
			{
				new Plot("corn", 30),
				new Plot("corn", 40),
				new Plot("corn", 50),
				new Plot("corn", 30)
			},
			{
				new Plot("peas", 10),
				new Plot("corn", 62),
				new Plot("rice", 30),
				new Plot("peas", 30)
			},
		};

		ExperimentalFarm ef = new ExperimentalFarm(temp);
		System.out.println(ef.getHighestYield("corn").getCropType());
		System.out.println(ef.sameCrop(0));
		System.out.println(ef.sameCrop(1));
	}

}

// for testing purposes
// public class Plot {
// 
// 	private String cropType;
// 
// 	private int cropYield;
// 
// 	public Plot(String crop, int yield) {
// 
// 		this.cropType = crop;
// 		this.cropYield = yield;
// 	}
// 
// 
// 	public String getCropType() {
// 
// 		return cropType;
// 
// 	}
// 
// 
// 
// 	public int getCropYield() {
// 
// 		return cropYield;
// 
// 	}
// 
// }
