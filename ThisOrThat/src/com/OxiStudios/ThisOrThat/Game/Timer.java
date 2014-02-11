package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class Timer {
	
	Thread timerThread;
	private GameScene gameScene;
	private double NANO = 1000000000.0;
	
	private long startTime;
	private long currentTime;
	
	public double gameTimer;
	
	public Timer(GameScene gameScene) {
		this.gameScene = gameScene;
		
		gameTimer = 3.5 * 1000; //3 seconds
		
		startTime   = TimeUtils.nanoTime();
		currentTime = TimeUtils.nanoTime();
		
		timerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(gameTimer > 0){
					countDown();
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						
					}
					currentTime = TimeUtils.nanoTime();
				}
			}
			
		});
		
	}
	
	private void countDown() {
		if(gameTimer >= 0.1) {
			gameTimer -= 10;			
		}else{
			gameTimer = 0;
			if(gameTimer == 0) {
				
			}
		}
		if(gameScene.gameScore >= 20.1) {
			gameScene.gameScore -= 2.5;			
		}else{
			gameScene.gameScore = 20;
		}
		Gdx.app.log("Timer", "" + gameTimer / 1000 + " Score: " + gameScene.gameScore);
	}
	
	public double getTimer() {
		return gameTimer / 1000;
	}

}
