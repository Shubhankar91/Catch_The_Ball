package com.android.ball1;



import com.android.ball.R;
import com.android.ball.R.anim;
import com.android.ball.R.id;
import com.android.ball.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MovementMedium extends Activity {
	int sound,high,bestScore;
	public static String filename = "bestScoreFile2";
	SharedPreferences data;
	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		Intent in = new Intent(MovementMedium.this,NewGame2.class);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		startActivity(in);
		mv.t.cancel();
		finish();
	}
	
	MovementViewMedium mv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	setContentView(R.layout.main);
    	data = getSharedPreferences(filename, 0);
        final TextView tv=(TextView)findViewById(R.id.timer);
        tv.setText("timer has to be put here");
        tv.setBackgroundColor(Color.GREEN);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(20);
        sound = getIntent().getExtras().getInt("Sound");
        bestScore = data.getInt("best", 0);
        mv=new MovementViewMedium(this);
        if(sound==1){
        	mv.play = 1;
        }
        else{
        	mv.play = 0;
        }
        mv.t = new CountDownTimer(30000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
		
				mv.r=mv.r+mv.p;
            	mv.g=mv.g-mv.p;
            	tv.setText("Time Left : " + millisUntilFinished / 1000 + "		POINTS : "+mv.points+"		BEST : "+bestScore);
    			}
			
			@Override
			public void onFinish() {
				if(mv.points >= bestScore){
					bestScore = mv.points;
				}
				Editor editor = data.edit();
				editor.putInt("best", bestScore);
				editor.commit();
				tv.setText("Time Up!");
				AlertDialog alert = new AlertDialog.Builder(MovementMedium.this).create();
				alert.setTitle("Score");
				alert.setMessage("Your Score is "+mv.points+"\nHigh Score : "+bestScore);
				alert.setButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
		
						Intent in = new Intent(MovementMedium.this,NewGame2.class);
						in.putExtra("sound", sound);
						overridePendingTransition(R.anim.fadein, R.anim.fadeout);
						startActivity(in);
						finish();
					}
				});
				alert.setButton2("Post your success to facebook?", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
					
						
						
						/*Intent in = new Intent(MovementMedium.this,PostOnFb.class);
						in.putExtra("points", mv.points);
						in.putExtra("gametype", "classic medium");
						in.putExtra("sound", sound);
						startActivity(in);
						overridePendingTransition(R.anim.fadein, R.anim.fadeout);
						finish();*/
					}
				});
				alert.show();
				
				
				
			}
		}.start();
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.gamesurface);
        rl.addView(mv);
        }
    }