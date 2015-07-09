package com.android.ball1;

import com.android.ball.R;
import com.android.ball.R.anim;
import com.android.ball.R.id;
import com.android.ball.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class splashtopsyturvy extends Activity{
	int sound;
	TextView tv;
	CountDownTimer t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	
		setContentView(R.layout.splash);
		tv = (TextView) findViewById(R.id.TextView01);
		t=new CountDownTimer(1000,1000) {
			
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				sound = getIntent().getExtras().getInt("Sound");
				Intent in = new Intent(splashtopsyturvy.this, TopsyTurvy.class);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				in.putExtra("Sound", sound);
				startActivity(in);
                finish();
			}
			
			
		}.start();
		/*
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//tv.setText("30 Seconds");
				sound = getIntent().getExtras().getInt("Sound");
				Intent in = new Intent(splash.this, Movement.class);
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				in.putExtra("Sound", sound);
				startActivity(in);
                finish();
			}
		}, 1000);
		*/
	}
	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		t.cancel();
		Intent in = new Intent(splashtopsyturvy.this,NewGame2.class);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		startActivity(in);
		finish();
	
	}
}
