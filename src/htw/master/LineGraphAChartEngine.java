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

public class LineGraphAChartEngine extends GraphKillzActivity {
	public Intent getIntent(Context context, int maxX, int maxY, int lines) {
				
		Random rand = new Random();
		int minY = 0;

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		
		for (int i=0; i<=lines; i++){
			
			TimeSeries series = new TimeSeries("Line 1".concat(String.valueOf(i)));
			for (int j=0; j<=maxX; j++) {
				series.add(j,rand.nextInt(maxY-minY+1)+minY);
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
