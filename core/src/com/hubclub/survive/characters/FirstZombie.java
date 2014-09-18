package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.Constants;

public class FirstZombie implements Character {

	private int charType = 2; // Means he is the mob ( 0 - object, 1 - bunny, 2 - mob)
	  						  // Helps at collisions
	private float x; // Coordinates
	private float y;
	private int stateTime; // Used to animate
	private int dir; // Used for direction (1 - right, 2 - down, 3 - left, 4 - up)
	private float speed = 120;// 120 pixels / second 
	private Rectangle hitBox;
	
	private float sum;
	private float time;
	private Texture currentState;
	
	public FirstZombie() {
		
		time = MathUtils.random(7);
		
		currentState = new Texture(Gdx.files.internal("images/zombie.png"));
		
		if(Constants.WIDTH_SCALE >= Constants.HEIGHT_SCALE) speed *= Constants.WIDTH_SCALE;
		else if (Constants.WIDTH_SCALE < Constants.HEIGHT_SCALE) speed *= Constants.HEIGHT_SCALE;
		
		int random = MathUtils.random(1);
		
		if(random == 0) {
			
			x = getRandomX();
			y = MathUtils.random(0f, Gdx.graphics.getHeight());
			
		} else if (random == 1) {
			
			y = getRandomY();
			x = MathUtils.random(0f, Gdx.graphics.getWidth());
			
		}
		
		hitBox = new Rectangle(x, y, getTexture().getWidth(), getTexture().getHeight());
		
		sum = 0f;
	}// END OF CONSTRUCTOR
		
	public void render(float deltaTime) {
		
		
		sum += deltaTime;
		
		if(sum >= time) {
			
			dir = MathUtils.random(1, 4);
			time = MathUtils.random(7);
			
			sum = 0f;
		}
		
		move(deltaTime);
	}// END OF render METHOD

	private void move(float deltaTime) {
		
		if(dir == 1) x-=speed * deltaTime;
		else if(dir == 2) y-=speed * deltaTime;
		else if(dir == 3) x+=speed * deltaTime;
		else if(dir == 4) y+=speed * deltaTime;
		
		if(x + getTexture().getWidth() < 0) x = Gdx.graphics.getWidth();
		else if(x > Gdx.graphics.getWidth()) x = 0;
		else if(y + getTexture().getHeight() < 0) y = Gdx.graphics.getHeight();
		else if(y > Gdx.graphics.getHeight()) y= 0;
		
	}// END OF move METHOD
	
	public int getCharType() {
		
		return charType;
	}

	public void setX(float x) {
		
		this.x = x;
		
	}

	public float getX() {

		return x;
	}

	public void setY(float y) {
		
		this.y = y;
	}

	public float getY() {
		
		return y;
	}
	
	public Rectangle getRectangle() {
		
		return hitBox;
	}
	
	public void dispose() {
		currentState.dispose();
	}

	public Texture getTexture() {

		return currentState;
	}
	
	
	// Used to spawn the zombie behind the screen
	private float getRandomX() {
		
		Array<Float> xArray = new Array<Float>();
		
		xArray.add(MathUtils.random(-getTexture().getWidth()*1f, 0f));
		xArray.add(MathUtils.random(Gdx.graphics.getWidth()*1f, Gdx.graphics.getWidth() + getTexture().getWidth()));
		
		int index = MathUtils.random(1);
		
		if(index == 0) dir = 3;
		else if (index == 1) dir = 1;
		return xArray.get(index);
		
	}// END OF getRandomX METHOD
	
	private float getRandomY() {
		
		Array<Float> yArray = new Array<Float>();
		
		yArray.add(MathUtils.random(-getTexture().getHeight()*1f, 0f));
		yArray.add(MathUtils.random(Gdx.graphics.getHeight()*1f, Gdx.graphics.getHeight() + getTexture().getHeight()));
		
		int index = MathUtils.random(1);
		
		if(index == 0) dir = 4;
		else if (index == 1) dir = 2;
		
		return yArray.get(index);
		
	}// END OF getRandomY METHOD
	
}
