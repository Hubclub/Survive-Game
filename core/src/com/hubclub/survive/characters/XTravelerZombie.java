package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.Constants;

public class XTravelerZombie implements Character {
	private int charType=2;//means this is a mob
	private int stateTime; // Used to animate
	private int dir = 1;// Used for direction (1 - right, 2 - down, 3 - left, 4 - up)
	private int speed = 80;
	
	private float minX,minY;
	
	private Rectangle hitBox; //retains coordinates plus width and height
	
	private Texture currentState;
	
	private Bunny bunny;
	
public XTravelerZombie(Bunny bunny){
		
		currentState = new Texture(Gdx.files.internal("images/zombie.png"));
		
		hitBox = new Rectangle();
		
		if(Constants.WIDTH_SCALE >= Constants.HEIGHT_SCALE) speed *= Constants.WIDTH_SCALE;
		else if (Constants.WIDTH_SCALE < Constants.HEIGHT_SCALE) speed *= Constants.HEIGHT_SCALE;
		
		int random = MathUtils.random(1);
		
		if(random == 0) {
			
			hitBox.x = getRandomX();
			hitBox.y = MathUtils.random(0f, Gdx.graphics.getHeight());
			
		} else if (random == 1) {
			
			hitBox.y = getRandomY();
			hitBox.x = MathUtils.random(0f, Gdx.graphics.getWidth());
			
		}
		
		this.bunny=bunny;
	}
	
public void render(float deltaTime) {
	// TODO Auto-generated method stuff
	
	move(deltaTime);
}

private void move(float deltaTime) {

	/*if(dir == 1) hitBox.x-=speed * deltaTime;
	else if(dir == 2) hitBox.y-=speed * deltaTime;
	else if(dir == 3) hitBox.x+=speed * deltaTime;
	else if(dir == 4) hitBox.y+=speed * deltaTime;*/
	
	if(Math.abs(hitBox.x-bunny.getX())<Gdx.graphics.getWidth()-Math.abs(hitBox.x-bunny.getX())){
		if(hitBox.x>bunny.getX())
			hitBox.x-=speed*deltaTime;
		else
			hitBox.x+=speed*deltaTime;
	}else{
		if(Gdx.graphics.getWidth()-hitBox.x+bunny.getX()<=Gdx.graphics.getWidth()+hitBox.x-bunny.getX())
			hitBox.x+=speed*deltaTime;
		else
			hitBox.x-=speed*deltaTime;
	}
	
	if(Math.abs(hitBox.y-bunny.getY())<Gdx.graphics.getHeight()-Math.abs(hitBox.y-bunny.getY())){
		if(hitBox.y>bunny.getY())
			hitBox.y-=speed*deltaTime;
		else
			hitBox.y+=speed*deltaTime;
	}else{
		if(Gdx.graphics.getHeight()-hitBox.y+bunny.getY()<=Gdx.graphics.getHeight()+hitBox.y-bunny.getY())
			hitBox.y+=speed*deltaTime;
		else
			hitBox.y-=speed*deltaTime;
	}
	
	
	if(hitBox.x<0)
		hitBox.x=Gdx.graphics.getWidth();
	else if(hitBox.x>Gdx.graphics.getWidth())
		hitBox.x=0;
	if(hitBox.y<0)
		hitBox.y=Gdx.graphics.getHeight();
	else if(hitBox.y>Gdx.graphics.getHeight())
		hitBox.y=0;
		
}// END OF move METHOD

public int getCharType() {
	// TODO Auto-generated method stub
	return charType;
}

public void setX(float x) {
	// TODO Auto-generated method stub
	
	hitBox.x = x;
}

public float getX() {
	// TODO Auto-generated method stub
	return hitBox.x;
}

public void setY(float y) {
	// TODO Auto-generated method stub
	
	hitBox.y = y;
}

public float getY() {
	// TODO Auto-generated method stub
	return hitBox.y;
}

public void dispose() {
	// TODO Auto-generated method stub
	currentState.dispose();
}

public Texture getTexture() {
	// TODO Auto-generated method stub
	return currentState;
}

public Rectangle getRectangle() {
	// TODO Auto-generated method stub
	return hitBox;
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
	
	private int min(float a,float b,float c){
		if(a<=b){
			if(a<=c){
				return 1;
			}else return 3;
		}else {
			if(b<=c) return 2;
			else return 3;
		}
	}

}
