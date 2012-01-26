package htw.master;


import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class LineGraphAChartEngine extends GraphKillzzActivity {
	public Intent getIntent(Context context, int maxX, int maxY, int lines, int tolerance) {
		
		int toleranceToLast = (maxY * tolerance)/100;
		
		Random rand = new Random();
		int minY = 0;

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		
		
		for (int i=0; i<lines; i++){
			int lastY = rand.nextInt(maxY-minY+1)+minY;
			TimeSeries series = new TimeSeries("Line ".concat(String.valueOf(i+1)));
			for (int j=0; j<=maxX; j++) {
				toleranceToLast = lastY*tolerance/100;
				lastY = rand.nextInt((lastY+toleranceToLast)-(lastY-toleranceToLast)+1)+(lastY-toleranceToLast);
				if (lastY > maxY)
					lastY = maxY;
				if (lastY < 0)
					lastY = 0;
				series.add(j,lastY);
			}
			dataset.addSeries(series);
			
			XYSeriesRenderer renderer = new XYSeriesRenderer();
			renderer.setColor(Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			mRenderer.addSeriesRenderer(renderer);
		}

		Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
		
		return intent;
	}
}
