package com.OxiStudios.ThisOrThat.Game;

import com.OxiStudios.ThisOrThat.ThisOrThatGame;
import com.badlogic.gdx.Gdx;

public class Timer {
	
	Thread timerThread;
	private GameScene gameScene;
	
	public double gameTimer;
	
	private boolean outOfTime;
	private ThisOrThatGame game;
	private boolean hardcore;
	
	public Timer(ThisOrThatGame game, GameScene gameScene, boolean hardcore) {
		this.game      = game;
		this.gameScene = gameScene;
		this.hardcore  = hardcore;
		
		if(hardcore){
			gameTimer = 1.2 * 1000; //1.2 seconds			
		}else{
			gameTimer = 2.2 * 1000; //1.2 seconds	
		}
		
		outOfTime = false;
		
		timerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(gameTimer > 0 && !Timer.this.gameScene.popUp){
					countDown();
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						
					}
				}
				
				outOfTime = true;
			}
			
		});
		
	}
	
	private void countDown() {
		if(gameTimer >= 0.1) {
			gameTimer -= 10;			
		}else{
			gameTimer = 0;
			outOfTime = true;
		}
		if(gameScene.gameScore >= 20.1) {
			gameScene.gameScore -= 2.5;			
		}else{
			gameScene.gameScore = 20;
		}
	}
	
	public double getTimer() {
		return gameTimer / 1000;
	}
	
	public void render() {
		if(outOfTime) {
			//display losing screen
			gameScene.gotItWrong = true;
			
			
		}
	}

}
