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

public class MovementFourBall extends Activity {

	MovementViewFourBall mv;
	int sound,high,bestScore;
	public static String filename = "bestScoreFileFourBall";
	SharedPreferences data;
	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		Intent in = new Intent(MovementFourBall.this,NewGame2.class);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		startActivity(in);
		mv.t.cancel();
		finish();
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	setContentView(R.layout.main);
        data = getSharedPreferences(filename, 0);
        final TextView tv=(TextView)findViewById(R.id.timer);
        tv.setText("timer has to be put here");
        tv.setBackgroundColor(Color.WHITE);
        tv.setTextColor(Color.BLUE);
        tv.setTextSize(20);
        
        bestScore = data.getInt("best", 0);
        sound = getIntent().getExtras().getInt("Sound");
        mv=new MovementViewFourBall(this);
        if(sound==1){
        	mv.play = 1;
        }
        else{
        	mv.play = 0;
        }
        mv.t = new CountDownTimer(60000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				
			
                tv.setText("Time Left : " + millisUntilFinished / 1000 + "		POINTS : "+mv.points+"		BEST : "+bestScore);
			}
			
			@Override
			public void onFinish() {
				
				tv.setText("Time Up!");
				if(mv.points >= bestScore){
					bestScore = mv.points;
				}
				Editor editor = data.edit();
				editor.putInt("best", bestScore);
				editor.commit();
				AlertDialog alert = new AlertDialog.Builder(MovementFourBall.this).create();
				alert.setTitle("Score");
				alert.setMessage("Your Score is "+mv.points+"\nHigh Score : "+bestScore);
				alert.setButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
				
						Intent in = new Intent(MovementFourBall.this,NewGame2.class);
						in.putExtra("sound", sound);
						startActivity(in);
						overridePendingTransition(R.anim.fadein, R.anim.fadeout);
						finish();
					}
				});
				alert.setButton2("Post your success to facebook?", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
					
						
						
						/*Intent in = new Intent(MovementFourBall.this,PostOnFb.class);
						in.putExtra("points", mv.points);
						in.putExtra("gametype", "Four Bust");
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

