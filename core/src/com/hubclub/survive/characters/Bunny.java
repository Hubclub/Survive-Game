package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.hubclub.survive.Constants;

public class Bunny implements Character {
	
	private int charType = 1; // Means he is the bunny ( 0 - object, 1 - bunny, 2 - mob)
							  // Helps at collisions
	private float x; // Coordinates
	private float y;
	private int stateTime; // Used to animate
	private int dir; // Used for direction (1 - right, 2 - down, 3 - left, 4 - up)
	private float speed = 200; // 200 pixels / second
	private Texture currentState;
	private Rectangle hitBox;
	
	private int deltaX; // Used for swipe. If this 2 variables aren't global
	private int deltaY; // the swipe won't work
	
	public Bunny() {
		
		dir = 1;
		
		if(Constants.WIDTH_SCALE >= Constants.HEIGHT_SCALE) speed *= Constants.WIDTH_SCALE;
		else if (Constants.WIDTH_SCALE < Constants.HEIGHT_SCALE) speed *= Constants.HEIGHT_SCALE;
		
		currentState = new Texture(Gdx.files.internal("images/monkey.png"));
		
		x = Gdx.graphics.getWidth() / 2;
		y = Gdx.graphics.getHeight() / 2;
		
		hitBox = new Rectangle(x, y, getTexture().getWidth(), getTexture().getHeight());
	}// END OF CONSTRUCTOR
	
	public void render(float deltaTime) {
		
		//stateTime += deltaTime / 2;
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
	
	
	// Helps with collissions
	public int getCharType() {
		
		return charType;
	}// END OF getCharType METHOD
	
	public void setX(float x) {
		
		this.x = x;
		
	}// END OF setX METHOD
	
	public float getX() {
		
		return x;
		
	}// END OF getX METHOD
	
	public void setY(float y) {
		
		this.y = y;
		
	}// END OF setY METHOD
	
	public float getY() {
		
		return y;
		
	}// END OF getY METHOD
	
	public Texture getTexture() {
		
		//TODO - return the current animation texture;
		return currentState;
		
	}// END OF getTexture METHOD
	
	public Rectangle getRectangle() {
		
		return hitBox;
	}
	
	public void dispose() {
		
		currentState.dispose();
		
	}// END OF dispose METHOD
	
	public class BunnyDesktopInputProcessor extends InputAdapter {
		
		
		public boolean keyDown (int keycode) {
			
			if(keycode == Keys.A || keycode == Keys.LEFT) dir = 1;
			else if(keycode == Keys.S || keycode == Keys.DOWN) dir = 2;
			else if(keycode == Keys.D || keycode == Keys.RIGHT) dir = 3;
			else if(keycode == Keys.W || keycode == Keys.UP) dir = 4;
			return super.keyDown(keycode);
			
		}// END OF keyDown METHOD
		
	}// END OF BunnyDesktopInputProcessor CLASS
	
	public class BunnyAndroidInputProcessor extends InputAdapter {
		
		public boolean touchDown (int screenX, int screenY, int pointer, int button) {
			
			deltaX = screenX;
			deltaY = screenY;
			
			return super.touchDown(screenX, screenY, pointer, button);
			
		}// END OF touchDown METHOD
		
		public boolean touchUp (int screenX, int screenY, int pointer, int button) {
			
			deltaX = deltaX - screenX;
			deltaY = deltaY - screenY;
			
			if(Math.abs(deltaX) > Math.abs(deltaY)) {
				
				if(deltaX < 0) {
					dir = 3;
				} else if(deltaX > 0) {
					dir = 1;
				}
				
			}else if(Math.abs(deltaX) < Math.abs(deltaY)) {
				
				if(deltaY < 0) {
					dir = 2;
				} else if(deltaY > 0) {
					dir = 4;
				}
			}
			
			return super.touchUp(screenX, screenY, pointer, button);
			
		}// END OF touchUp METHOD
		
	}// END OF BunnyAndroidInputProcessor CLASS
	
}// END OF Bunny CLASS