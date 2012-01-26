package htw.fps;

import htw.master.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MaxFPSActivity extends Activity{
	private MaxFPSActivity maxFpsView;

	private MaxFPSThread maxFpsThread;;

	protected void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.main);
	}

	@Override
	protected void onStart() {
	super.onStart();
	startGame();
	}

	private void startGame() {
	maxFpsView = (MaxFPSActivity) findViewById(R.id.maxfps);

	// hack to force the surface view to set the parameters
	maxFpsThread = maxFpsView.getThread();
	maxFpsThread.setRunning(true);
	maxFpsThread.start();
	}
}
