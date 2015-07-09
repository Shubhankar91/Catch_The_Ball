package com.android.ball1;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class UpdateThreadThreeBall extends Thread {
    private long time;
    private final int fps = 40;
    private boolean toRun = false;
    private MovementViewThreeBall movementView;
    private SurfaceHolder surfaceHolder;
    
    public UpdateThreadThreeBall(MovementViewThreeBall rMovementView) {
        movementView = rMovementView;
        surfaceHolder = movementView.getHolder();
    }

	public void setRunning(boolean b) {
		
		toRun = b;
	}

	@Override
	public void run() {
		
		Canvas c;
		while(toRun){
			long cTime = System.currentTimeMillis();
			if((cTime - time) <= (1000/fps)){
				c = null;
				try{
					c = surfaceHolder.lockCanvas(null);
					movementView.updatePhysics();
					movementView.onDraw(c);
				}
				finally{
					if(c != null){
						surfaceHolder.unlockCanvasAndPost(c);
					}
				}
			}
			time = cTime;
		}
	}
    
}

