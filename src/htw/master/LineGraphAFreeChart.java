package htw.master;


import java.util.Random;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.data.time.Month;
import org.afree.data.time.TimeSeries;
import org.afree.data.time.TimeSeriesCollection;


import android.content.Context;


public class LineGraphAFreeChart extends GraphKillzzActivity {
	public AFreeChart getChart(Context context, int maxX, int maxY, int lines, int tolerance) {
		
		int toleranceToLast = (maxY * tolerance)/100;
		
		Random rand = new Random();
		int minY = 0;

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		
		for (int i=0; i<lines; i++){
			int lastY = rand.nextInt(maxY-minY+1)+minY;
			TimeSeries series = new TimeSeries("Line ".concat(String.valueOf(i+1)));
			int year = 2000;
			int month = 0;
			for (int j=0; j<=maxX; j++) {
				toleranceToLast = lastY*tolerance/100;
				lastY = rand.nextInt((lastY+toleranceToLast)-(lastY-toleranceToLast)+1)+(lastY-toleranceToLast);
				if (lastY > maxY)
					lastY = maxY;
				if (lastY < 0)
					lastY = 0;
				if (j % 12 == 0){
					month = 0;
					year++;
				}
				series.add(new Month(++month, ++year),lastY);
			}
			dataset.addSeries(series);
			
			

		}

		AFreeChart chart = ChartFactory.createTimeSeriesChart(
	            "Line Graph Title",  // title
	            "Date",             // x-axis label
	            "y-axis label",   // y-axis label
	            dataset,            // data
	            true,               // create legend?
	            false,               // generate tooltips?
	            false               // generate URLs?
	        ); 
		//Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
		
		return chart;
	}
}
