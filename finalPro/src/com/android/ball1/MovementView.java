package com.android.ball1;

import java.util.Random;

import com.android.ball.R;
import com.android.ball.R.raw;



import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class MovementView extends SurfaceView implements SurfaceHolder.Callback {
	 private int xPos,xPos2;
	    private int yPos,yPos2;
	    private int xVel,xVel2;
	    private int yVel,yVel2;
	    public long tNow;
	    private int mX;
	    private int mY;
	    private int vel;
	    int r,g,p;
	    Resources res;
	    MediaPlayer player;
	    int play;
	    int points;
	    Bitmap bg;
	    private int width;
	    private int height;
	    CountDownTimer t;
	    private int circleRadius;
	    private Paint circlePaint,circlePaint2;
	    UpdateThread updateThread,updateThread2;
	    public MovementView(Context context) {
	        super(context);
	        getHolder().addCallback(this);
	       res = getResources();
	        int radius = (int) (20*res.getDisplayMetrics().density);
	        circleRadius = radius;
	        vel=(int) (5*res.getDisplayMetrics().density);
	        circlePaint = new Paint();
	        r=0;g=255;p=(int)(255/30);
	        circlePaint.setColor(Color.rgb(r,g,0));
	        xVel = vel;
	        yVel = vel;
	        points=0;
	        circlePaint2 = new Paint();
	        circlePaint2.setColor(Color.BLACK);
	        xVel2 = vel;
	        yVel2 = vel;
	        player  = MediaPlayer.create(getContext(), R.raw.sound);
	     
	    }
	    @Override
	    protected void onDraw(Canvas canvas) {
	        canvas.drawColor(Color.WHITE);
	        
	        Paint p=new Paint();
	     
	        p.setColor(Color.RED);
	       canvas.drawCircle(xPos, yPos, circleRadius, circlePaint);
	        canvas.drawCircle(xPos2, yPos2, circleRadius, circlePaint2);
	    }
	    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	        
	        int eventaction = event.getAction();
	        
	        switch (eventaction){
						           	case MotionEvent.ACTION_DOWN: 
						                
						           		mX = (int) event.getX();
						                mY = (int) event.getY();
						                if(points < 100){
					                	}
					                	else if(points >=100 && points <200){
					                		xVel = (int) (7*res.getDisplayMetrics().density);
					                		yVel = (int) (7*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 200 && points < 300){
					                		xVel = (int) (9*res.getDisplayMetrics().density);
					                		yVel = (int) (9*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 300 && points < 400){
					                		xVel = (int) (11*res.getDisplayMetrics().density);
					                		yVel = (int) (11*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 400 && points < 500){
					                		xVel = (int) (13*res.getDisplayMetrics().density);
					                		yVel = (int) (13*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 500 && points < 600){
					                		xVel = (int) (15*res.getDisplayMetrics().density);
					                		yVel = (int) (15*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 600 && points < 700){
					                		xVel = (int) (17*res.getDisplayMetrics().density);
					                		yVel = (int) (17*res.getDisplayMetrics().density);
					                	}
					                	else if(points >= 700){
					                		xVel = (int) (20*res.getDisplayMetrics().density);
					                		yVel = (int) (20*res.getDisplayMetrics().density);
					                	}
						                if(mX-xPos<=circleRadius&&mY-yPos<=circleRadius)
						                {
						                
						                	
						                	if(points < 100){
						                		points+=10;
						                	}
						                	else if(points >=100 && points <200){
						                		points+=12;
						                	}
						                	else if(points >= 200 && points < 300){
						                		points+=14;
						                	}
						                	else if(points >= 300 && points < 400){
						                		points+=16;
						                	}
						                	else if(points >= 400 && points < 500){
		
						                		points+=16;
						                	}
						                	else if(points >= 500 && points < 600){
						                		points+=18;
						                	}
						                	else if(points >= 600 && points < 700){
						                		points+=20;
						                	}
						                	else if(points >= 700){
						                		points+=22;
						                	}
						                }
						                if(mX-xPos2<=circleRadius&&mY-yPos2<=circleRadius)
						                {
						                	
						                	if(points < 100){
						                		points-=5;
						                	}
						                	else if(points >=100 && points <200){
						                		points-=6;
						                	}
						                	else if(points >= 200 && points < 300){
						                		points-=7;
						                	}
						                	else if(points >= 300 && points < 400){
						                		points-=8;
						                	}
						                	else if(points >= 400 && points < 500){
						                		points-=8;
						                	}
						                	else if(points >= 500 && points < 600){
						                		points-=9;
						                	}
						                	else if(points >= 600 && points < 700){
						                		points-=10;
						                	}
						                	else if(points >= 700){
						                		points-=11;
						                	}
						                }
							        
	        					}
	        return super.onTouchEvent(event);
	    }
	    public void updatePhysics() {
	        xPos += xVel;
	        yPos += yVel;
	        
	        if (yPos - circleRadius < 0 || yPos + circleRadius > height) {
	        	if(play == 1){
	        	player.start();
	        	}
	            if (yPos - circleRadius < 0) {
	                yPos = circleRadius;
	            }else{
	                yPos = height - circleRadius;
	            }
	            yVel *= -1;
	        }
	        if (xPos - circleRadius < 0 || xPos + circleRadius > width) {
	        	if(play == 1){
		        	player.start();
		        	}
	            if (xPos - circleRadius < 0) {
	                xPos = circleRadius;
	            } else {
	                xPos = width - circleRadius;
	            }
	            xVel *= -1;
	        }
	       
	        circlePaint.setColor(Color.rgb(r,g,0));
	        xPos2 += xVel2;
	        yPos2 += yVel2;
	        
	        if (yPos2 - circleRadius < 0 || yPos2 + circleRadius > height) {
	        	if(play == 1){
	        		if(play == 1){
			        	player.start();
			        	}
		        	}
	            if (yPos2 - circleRadius < 0) {
	                yPos2 = circleRadius;
	            }else{
	                yPos2 = height - circleRadius;
	            }
	            yVel2 *= -1;
	        }
	        if (xPos2 - circleRadius < 0 || xPos2 + circleRadius > width) {
	        	player.start();
	        	if (xPos2 - circleRadius < 0) {
	                xPos2 = circleRadius;
	            } else {
	                xPos2 = width - circleRadius;
	            }
	            xVel2 *= -1;
	        }
	        
	    }
	    public void surfaceCreated(SurfaceHolder holder) {
	        Rect surfaceFrame = holder.getSurfaceFrame();
	        width = surfaceFrame.width();
	        height = surfaceFrame.height();
	        Random rand = new Random();
	        int ran = rand.nextInt()%1000;
	        if(ran < 0 )
	        	ran = -ran;
	        else if(ran == 0)
	        	ran = 2;
	        
	        xPos = ran;
	        yPos = ran;
	        updateThread = new UpdateThread(this);
	        updateThread.setRunning(true);
	        updateThread.start();
	        
	        xPos2 = width/2;
	        yPos2 = circleRadius;
	        updateThread2 = new UpdateThread(this);
	        updateThread2.setRunning(true);
	        updateThread2.start();
	    }
	    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	    }
	    public void surfaceDestroyed(SurfaceHolder holder) {
	        boolean retry = true;
	        updateThread.setRunning(false);
	        updateThread2.setRunning(false);
	        while (retry) {
	            try {
	                updateThread.join();
	                updateThread2.join();
	                retry = false;
	            } catch (InterruptedException e) {
	            }
	        }
	    }
}


