package rl.BalloonAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	FrameLayout layout;
    View balloon;
    boolean isT=false;
	int start = 0, end = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		layout = findViewById(R.id.layout);	
        balloon = findViewById(R.id.car);
    }
    public void onSlide(View view) {
		if (isT) {
			start = layout.getHeight() - balloon.getHeight();
			end = 0;
		} else {
			start = 0;
			end = layout.getHeight() - balloon.getHeight();
		}

		TranslateAnimation animate = new TranslateAnimation(
			0     , // fromXDelta
			0     , // toXDelta
			- start , // fromYDelta
			- end     // toYDelta
		);
		balloon.startAnimation(animate);
		animate.setDuration(500);
		animate.setFillAfter(true);
		((Button) view).setText(
			isT ?
			"Up"
			:
			"Down"
		);
		isT = ! isT;
    }
}
