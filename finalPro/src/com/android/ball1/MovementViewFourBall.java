package com.android.ball1;

import java.util.Random;

import com.android.ball.R;
import com.android.ball.R.raw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MovementViewFourBall extends SurfaceView implements SurfaceHolder.Callback {
	 private int xPos,xPos2,xPos3,xPos4;
	    private int yPos,yPos2,yPos3,yPos4;
	    private int xVel,xVel2,xVel3,xVel4;
	    private int yVel,yVel2,yVel3,yVel4;
	    public long tNow;
	    private int mX;
	    private int mY;
	    int vel;
	    int r,g,p;
	    MediaPlayer player;
	    
	    int points,play;
	    
	    private int width;
	    private int height;
	    CountDownTimer t;
	    private int circleRadius,circleRadius2,circleRadius3,circleRadius4;
	    private Paint circlePaint,circlePaint2,circlePaint3,circlePaint4;
	    UpdateThreadFourBall updateThread,updateThread2,updateThread3,updateThread4;
	    public MovementViewFourBall(Context context) {
	        super(context);
	        getHolder().addCallback(this);
	        Resources res = getResources();
	        int radius = (int) (22*res.getDisplayMetrics().density);
	        circleRadius = radius;
	       
	        int radius2 = (int) (22*res.getDisplayMetrics().density);
	        circleRadius2 = radius2;
	        int radius3 = (int) (16*res.getDisplayMetrics().density);
	        circleRadius3 = radius3;

	        int radius4 = (int) (18*res.getDisplayMetrics().density);
	        circleRadius4 = radius4;
	        vel=(int) (7*res.getDisplayMetrics().density);
	        circlePaint = new Paint();
	        r=0;g=255;p=(int)(255/45);
	        circlePaint.setColor(Color.rgb(r,g,0));
	        xVel = vel;
	        yVel = vel;
	        points=0;
	        circlePaint2 = new Paint();
	        circlePaint2.setColor(Color.BLACK);
	        int vel2=(int) (6*res.getDisplayMetrics().density);
	        xVel2 = vel2;
	        yVel2 = vel2;
	        circlePaint3 = new Paint();
	        circlePaint3.setColor(Color.BLUE);
	        int vel3=(int) (5*res.getDisplayMetrics().density);
	        xVel3 = vel3;
	        yVel3 = vel3;
	        circlePaint4 = new Paint();
	        circlePaint4.setColor(Color.RED);
	        int vel4=(int) (4*res.getDisplayMetrics().density);
	        xVel4 = vel4;
	        yVel4 = vel4;
	        player  = MediaPlayer.create(getContext(), R.raw.sound);
	        
	    }
	    @Override
	    protected void onDraw(Canvas canvas) {
	        canvas.drawColor(Color.WHITE);
	        
	        Paint p=new Paint();
	       canvas.drawCircle(xPos, yPos, circleRadius, circlePaint);
	        canvas.drawCircle(xPos2, yPos2, circleRadius2, circlePaint2);
	        canvas.drawCircle(xPos3, yPos3, circleRadius3, circlePaint3);
	        canvas.drawCircle(xPos4, yPos4, circleRadius4, circlePaint4);
	    }
	    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	        
	        int eventaction = event.getAction();
	        
	        switch (eventaction){
						           	case MotionEvent.ACTION_DOWN: 
						               
						           		mX = (int) event.getX();
						                mY = (int) event.getY();
						                if(points < 100){
					                		
						                	circlePaint3.setColor(Color.BLUE);
						                	circlePaint4.setColor(Color.RED);
						                	
					                	}
					                	else if(points >=100 && points <150){
					                		circlePaint3.setColor(Color.RED);
					                		circlePaint4.setColor(Color.BLUE);
					                	}
					                	else if(points >= 150 && points < 200){
					                		circlePaint3.setColor(Color.BLUE);
					                		circlePaint4.setColor(Color.RED);
					                	}
					                	else if(points >= 200 && points < 250){
					                		circlePaint3.setColor(Color.RED);
					                		circlePaint4.setColor(Color.BLUE);
					                	}
					                	else if(points >= 250 && points < 350){
					                		circlePaint3.setColor(Color.BLUE);
					                		circlePaint4.setColor(Color.RED);
					                	}
					                	else if(points >= 350 && points < 500){
					                		circlePaint3.setColor(Color.RED);
					                		circlePaint4.setColor(Color.BLUE);
					                	}
					                	else if(points >= 500 && points < 700){
					                		circlePaint3.setColor(Color.BLUE);
					                		circlePaint4.setColor(Color.RED);
					                	}
					                	else if(points >= 700){
					             
					                		circlePaint3.setColor(Color.RED);
					                		circlePaint4.setColor(Color.BLUE);
					                		
					                	}
					                }
					         
					                	
						                if(mX-xPos<=circleRadius&&mY-yPos<=circleRadius)
						                {
						                	
						                	if(points < 100){
						                		points+=8;
						                	}
						                	else if(points >=100 && points <200){
						                		
						                		points+=10;
						                		
						                	}
						                	else if(points >= 200 && points < 300){
						                		points+=12;
						                		}
						                	else if(points >= 300 && points < 400){
						                		points+=14;
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
						                if(mX-xPos2<=circleRadius2&&mY-yPos2<=circleRadius2)
						                {
						                	
						                	if(points < 100){
						                		points-=8;
						                	}
						                	else if(points >=100 && points <200){
						                		points-=9;
						                		
						                	}
						                	else if(points >= 200 && points < 300){
						                		points-=10;
						                	}
						                	else if(points >= 300 && points < 400){
						                		points-=11;
						                	}
						                	else if(points >= 400 && points < 500){
						                		points-=12;
						                	}
						                	else if(points >= 500 && points < 600){
						                		points-=13;
						                	}
						                	else if(points >= 600 && points < 700){
						                		points-=14;
						                	}
						                	else if(points >= 700){
						                		points-=15;
						                	}
						                }
						                if(mX-xPos3<=circleRadius3&&mY-yPos3<=circleRadius3)
						                {
						                	
						                	if(points < 100){
						                		points+=20;
						                	}
						                	else if(points >=100 && points <150){
						                		points-=20;
						                		
						                		
						                	}
						                	else if(points >= 150 && points < 200){
						                		points+=30;
						                	}
						                	else if(points >= 200 && points < 250){
						                		points-=30;
						                	}
						                	else if(points >= 250 && points < 350){
						                		points+=40;
						                	}
						                	else if(points >= 350 && points < 500){
						                		points-=40;
						                	}
						                	else if(points >= 500 && points < 700){
						                		points+=50;
						                		
						                	}
						                	else if(points >= 700){
						                		points-=50;
						                	}
						                	
						                }
						                
						                if(mX-xPos4<=circleRadius3&&mY-yPos4<=circleRadius4)
						                {
						                	
						                	if(points < 100){
						                		points-=20;
						                	}
						                	else if(points >=100 && points <150){
						                		points+=20;
						                		
						                		
						                	}
						                	else if(points >= 150 && points < 200){
						                		points-=30;
						                	}
						                	else if(points >= 200 && points < 250){
						                		points+=30;
						                	}
						                	else if(points >= 250 && points < 350){
						                		points-=40;
						                	}
						                	else if(points >= 350 && points < 500){
						                		points+=40;
						                	}
						                	else if(points >= 500 && points < 700){
						                		points-=50;
						                		
						                	}
						                	else if(points >= 700){
						                		points+=50;
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
		        	player.start();
		        	}
	            if (yPos2 - circleRadius < 0) {
	                yPos2 = circleRadius;
	            }else{
	                yPos2 = height - circleRadius;
	            }
	            yVel2 *= -1;
	        }
	        if (xPos2 - circleRadius < 0 || xPos2 + circleRadius > width) {
	        	if(play == 1){
		        	player.start();
		        	}
	        	if (xPos2 - circleRadius < 0) {
	                xPos2 = circleRadius;
	            } else {
	                xPos2 = width - circleRadius;
	            }
	            xVel2 *= -1;
	        }
	        
	        xPos3 += xVel3;
	        yPos3 += yVel3;
	        
	        if (yPos3 - circleRadius3 < 0 || yPos3 + circleRadius3 > height) {
	        	if(play == 1){
		        	player.start();
		        	}
	            if (yPos3 - circleRadius3 < 0) {
	                yPos3 = circleRadius3;
	            }else{
	                yPos3 = height - circleRadius3;
	            }
	            yVel3 *= -1;
	        }
	        if (xPos3 - circleRadius3 < 0 || xPos3 + circleRadius3 > width) {
	        	if(play == 1){
		        	player.start();
		        	}
	        	if (xPos3 - circleRadius3 < 0) {
	                xPos3 = circleRadius3;
	            } else {
	                xPos3 = width - circleRadius3;
	            }
	            xVel3 *= -1;
	        }
	        
	        xPos4 += xVel4;
	        yPos4 += yVel4;
	        
	        if (yPos4 - circleRadius4 < 0 || yPos4 + circleRadius4 > height) {
	        	if(play == 1){
		        	player.start();
		        	}
	            if (yPos4 - circleRadius4 < 0) {
	                yPos4 = circleRadius4;
	            }else{
	                yPos4 = height - circleRadius4;
	            }
	            yVel4 *= -1;
	        }
	        if (xPos4 - circleRadius4 < 0 || xPos4 + circleRadius4 > width) {
	        	if(play == 1){
		        	player.start();
		        	}
	        	if (xPos4 - circleRadius4 < 0) {
	                xPos4 = circleRadius4;
	            } else {
	                xPos4 = width - circleRadius4;
	            }
	            xVel4 *= -1;
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
	        updateThread = new UpdateThreadFourBall(this);
	        updateThread.setRunning(true);
	        updateThread.start();
	        
	        xPos2 = width/2;
	        yPos2 = circleRadius;
	        updateThread2 = new UpdateThreadFourBall(this);
	        updateThread2.setRunning(true);
	        updateThread2.start();
	        
	        xPos3 = width/2;
	        yPos3 = circleRadius;
	        updateThread3 = new UpdateThreadFourBall(this);
	        updateThread3.setRunning(true);
	        updateThread3.start();
	        
	        xPos4 = ran;
	        yPos4 = circleRadius;
	        updateThread4 = new UpdateThreadFourBall(this);
	        updateThread4.setRunning(true);
	        updateThread4.start();
	        
	    }
	    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	    }
	    public void surfaceDestroyed(SurfaceHolder holder) {
	        boolean retry = true;
	        updateThread.setRunning(false);
	        updateThread2.setRunning(false);
	        updateThread3.setRunning(false);
	        updateThread4.setRunning(false);
	        
	        while (retry) {
	            try {
	                updateThread.join();
	                updateThread2.join();
	                updateThread3.join();
	                updateThread4.join();
	                retry = false;
	            } catch (InterruptedException e) {
	            }
	        }
	    }
}

