package htw.master;

import org.afree.chart.AFreeChart;
import org.afree.chart.plot.Plot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class GraphKillzzActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
    }
    
    public void lineGraphAChartEngineHandler(View view) {
    	final EditText linesField = (EditText) findViewById(R.id.lines);
    	final EditText stepsField = (EditText) findViewById(R.id.steps);
    	final EditText rangeField = (EditText) findViewById(R.id.range);
    	final EditText toleranceField = (EditText) findViewById(R.id.tolerance);
    	
    	int x = Integer.valueOf(stepsField.getText().toString());
    	int y = Integer.valueOf(rangeField.getText().toString());
    	int lines = Integer.valueOf(linesField.getText().toString());
    	int tolerance = Integer.valueOf(toleranceField.getText().toString());
    	    	
    	long start = System.currentTimeMillis();
    	
		LineGraphAChartEngine lineChartEngine = new LineGraphAChartEngine();
		Intent lineIntent = lineChartEngine.getIntent(this, x, y, lines, tolerance);
		startActivity(lineIntent);
		
		long end = System.currentTimeMillis();
		long elapsedTime = end-start;
		
		Log.d("Time for ".concat(String.valueOf(lines)), String.valueOf(elapsedTime/1000F));
	}
    
    
    public void lineGraphAFreeChartHandler(View view) {
    	final EditText linesField = (EditText) findViewById(R.id.lines);
    	final EditText stepsField = (EditText) findViewById(R.id.steps);
    	final EditText rangeField = (EditText) findViewById(R.id.range);
    	final EditText toleranceField = (EditText) findViewById(R.id.tolerance);
    	
    	int x = Integer.valueOf(stepsField.getText().toString());
    	int y = Integer.valueOf(rangeField.getText().toString());
    	int lines = Integer.valueOf(linesField.getText().toString());
    	int tolerance = Integer.valueOf(toleranceField.getText().toString());
    	    	
    	long start = System.currentTimeMillis();
    	
		LineGraphAFreeChart lineChartEngine = new LineGraphAFreeChart();
		AFreeChart chart = lineChartEngine.getChart(this, x, y, lines, tolerance);

		Intent intent = new Intent();
		//intent.setComponent(chart);
		startActivity(intent);
		
		long end = System.currentTimeMillis();
		long elapsedTime = end-start;
		
		Log.d("Time for ".concat(String.valueOf(lines)), String.valueOf(elapsedTime/1000F));
	}
 
}