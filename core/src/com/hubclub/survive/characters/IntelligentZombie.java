package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class IntelligentZombie implements Character {

	private int charType=2;//means this is a mob
	private int stateTime; // Used to animate
	private int dir;// Used for direction (1 - right, 2 - down, 3 - left, 4 - up)
	private int speed=150;
	
	private Rectangle charRect;//retains coordinates plus width and height
	
	private Texture currentState;
	
	private Bunny bunny;
	
	public IntelligentZombie(Bunny bunny){
		currentState=new Texture(Gdx.files.internal("images/zombie.png"));
		charRect=new Rectangle(-currentState.getWidth(),-currentState.getHeight(),currentState.getWidth(),currentState.getHeight());
		this.bunny=bunny;
	}
	
	@Override
	public void render(float deltaTime) {
		// TODO Auto-generated method stub
		if(Math.abs(charRect.x-bunny.getX())>Math.abs(charRect.y-bunny.getY())){
			if(charRect.x<bunny.getX()){
				charRect.x+=speed*deltaTime;
			}else if(charRect.x>bunny.getX()) {
				charRect.x-=speed*deltaTime;
			}
		}else{
			if(charRect.y<bunny.getY()){
				charRect.y+=speed*deltaTime;
			}else if(charRect.y>bunny.getY()) {
				charRect.y-=speed*deltaTime;
			}
		}
		
	}

	@Override
	public int getCharType() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return charRect.x;
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return charRect.y;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		currentState.dispose();
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return currentState;
	}

}
