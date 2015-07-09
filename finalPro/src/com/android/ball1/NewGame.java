package com.android.ball1;






import com.android.ball.R;
import com.android.ball.R.anim;
import com.android.ball.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class NewGame extends Activity {
	int sound;
	TextView tv;
	Handler hn;
	CountDownTimer t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	
		setContentView(R.layout.mainsplash2);
		
		t=new CountDownTimer(5000,1000) {
		
		
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				Intent in = new Intent(NewGame.this, NewGame2.class);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				startActivity(in);
                finish();
			}
			
			
		}.start();
		
		/*hn=new Handler();
		hn.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent in = new Intent(NewGame.this, NewGame2.class);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				startActivity(in);
                finish();
			}
		}, 5000);
		*/
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		t.cancel();
		
		finish();
		
	}

	
}
