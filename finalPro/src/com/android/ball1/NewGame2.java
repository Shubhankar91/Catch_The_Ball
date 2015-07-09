package com.android.ball1;

import com.android.ball.R;
import com.android.ball.R.anim;
import com.android.ball.R.id;
import com.android.ball.R.layout;
import com.android.ball.R.raw;

import android.app.Activity;
//import com.google.ads.AdView;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
public class NewGame2 extends Activity {
	Button newGame, highScore, options,credit;
	int sound=0;
	MediaPlayer player;
	//private AdView adView;
	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		player.stop();
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		finish();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.newgame);
		
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		newGame = (Button) findViewById(R.id.Button01);
		highScore = (Button) findViewById(R.id.Button03);
		options = (Button) findViewById(R.id.Button04);
		credit = (Button) findViewById(R.id.Button02);
		player  = MediaPlayer.create(this, R.raw.sound);
		//sound=getIntent().getExtras().getInt("sound");
		newGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(sound == 1){
		        	player.start();
		        	}
				AlertDialog alert1 = new AlertDialog.Builder(NewGame2.this).create();
				alert1.setTitle("Game Mode");
				alert1.setButton("Classic", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						if(sound == 1){
				        	player.start();
				        	}
						AlertDialog alert = new AlertDialog.Builder(NewGame2.this).create();
						alert.setTitle("Select Level");
						alert.setButton("Easy", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if(sound == 1){
						        	player.start();
						        	}
								Intent in = new Intent(NewGame2.this,splash.class);
								in.putExtra("Sound", sound);
								startActivity(in);
								overridePendingTransition(R.anim.fadein, R.anim.fadeout);
								finish();
							}
						});
						
						alert.setButton2("Hard", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if(sound == 1){
						        	player.start();
						        	}
								Intent in = new Intent(NewGame2.this,splash3.class);
								in.putExtra("Sound", sound);
								overridePendingTransition(R.anim.fadein, R.anim.fadeout);
								startActivity(in);
								finish();
							}
						});
						alert.setButton3("Medium", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if(sound == 1){
						        	player.start();
						        	}
								Intent in = new Intent(NewGame2.this,splash2.class);
								in.putExtra("Sound", sound);
								overridePendingTransition(R.anim.fadein, R.anim.fadeout);
								startActivity(in);
								finish();
							}
						});
						alert.show();
					}
					
				});
				alert1.setButton2("Arcade", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if(sound == 1){
				        	player.start();
				        	}
						// TODO Auto-generated method stub
						AlertDialog alert = new AlertDialog.Builder(NewGame2.this).create();
						alert.setTitle("No of balls!");
						alert.setButton("3 balls", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if(sound == 1){
						        	player.start();
						        	}
								Intent in = new Intent(NewGame2.this,splashthreeball.class);
								in.putExtra("Sound", sound);
								startActivity(in);
								overridePendingTransition(R.anim.fadein, R.anim.fadeout);
								finish();
							}
						});
						
						alert.setButton2("4 balls", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if(sound == 1){
						        	player.start();
						        	}
								Intent in = new Intent(NewGame2.this,splashfourball.class);
								in.putExtra("Sound", sound);
								overridePendingTransition(R.anim.fadein, R.anim.fadeout);
								startActivity(in);
								finish();
							}
						});
						alert.show();
					}
					
				});
				alert1.setButton3("Topsy Turpy", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if(sound == 1){
				        	player.start();
				        	}
						//put topsy turpy code here!!
						Intent in = new Intent(NewGame2.this,splashtopsyturvy.class);
						in.putExtra("Sound", sound);
						overridePendingTransition(R.anim.fadein, R.anim.fadeout);
						startActivity(in);
						finish();
						
					}
					});
				alert1.show();
			}
		});
		
		options.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(sound == 1){
		        	player.start();
		        	}
				AlertDialog alert = new AlertDialog.Builder(NewGame2.this).create();
				alert.setTitle("Options");
				alert.setButton("sound off", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
		
						
						sound = 0;
						
					}
				});
				alert.setButton2("sound on", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
						
						sound = 1;
						if(sound == 1){
				        	player.start();
				        	}
						
					}
				});
				alert.show();
			}
		});
		credit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(sound == 1){
		        	player.start();
		        	}
				
				Dialog d = new Dialog(NewGame2.this);
				d.setTitle("Help");
				TextView tv = new TextView(NewGame2.this);
				d.setContentView(R.layout.help);
				//tv.setTextSize(12);
				//tv.setText(" Just Tap the ball to score points. Beware of the Black Balls!They can decrease your points! The faster u are, the more points u will score!\n1.Classic mode\n Compete in three levels Easy Medium and Tough \n 2.TopsyTurvy Mode \n Black and Green balls switch values after 15seconds...Are you ready? \n 3.Arcade \n Try your luck against 3 or 4 balls of varying sizes,speeds and points(Yes there are penalty balls too!!) \nThis Game was developed by \nShubhankar\nParitosh Ramanan\n\nEnjoy!");
				//d.setContentView(tv);
				d.show();
				
				
			}
			
			
		});
	}
	
}

