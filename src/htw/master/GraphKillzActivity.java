package htw.master;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class GraphKillzActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
    }
    
    public void lineGraphAChartEngineHandler(View view) {
    	final EditText linesField = (EditText) findViewById(R.id.lines);
    	final EditText stepsField = (EditText) findViewById(R.id.steps);
    	int x = Integer.valueOf(stepsField.getText().toString());
    	int y = 200;
    	int lines = Integer.valueOf(linesField.getText().toString());;
    	    	
    	long start = System.currentTimeMillis();
    	
		LineGraphAChartEngine line = new LineGraphAChartEngine();
		Intent lineIntent = line.getIntent(this, x, y, lines);
		startActivity(lineIntent);
		
		long end = System.currentTimeMillis();
		long elapsedTime = end-start;
		
		Log.d("Time for ".concat(String.valueOf(lines)), String.valueOf(elapsedTime/1000F));
	}
}