package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class FirstZombie implements Character {

	private int charType = 2; // Means he is the bunny ( 0 - object, 1 - bunny, 2 - mob)
	  						  // Helps at collisions
	private float x; // Coordinates
	private float y;
	private int stateTime; // Used to animate
	private int dir; // Used for direction (1 - right, 2 - down, 3 - left, 4 - up)
	private int speed = 150; // 200 pixels / second
	private float time;
	private Texture currentState;
	
	public FirstZombie() {
		
		dir = MathUtils.random(1, 4);
		time = MathUtils.random(7);
		
		currentState = new Texture(Gdx.files.internal("images/zombie.png"));
		
		x = MathUtils.random(0, Gdx.graphics.getWidth());
		y = MathUtils.random(0, Gdx.graphics.getHeight());
		
		
	}// END OF CONSTRUCTOR
		
	public void render(float deltaTime) {
		
	}// END OF render METHOD

	private void move(float deltaTime) {
		
		
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

	public void dispose() {
		
	}

	public Texture getTexture() {

		return currentState;
	}
	
}
