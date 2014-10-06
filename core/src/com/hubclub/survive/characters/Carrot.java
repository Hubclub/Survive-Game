package com.hubclub.survive.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Carrot implements Character{

	private int charType=0;// Means he is the bunny ( 0 - object, 1 - bunny, 2 - mob)
	  					  // Helps at collisions
	
	private float time;
	
	private Rectangle box;

	private Texture texture;
	
	private boolean eaten=false;
	

	
	public Carrot(){
		texture=new Texture(Gdx.files.internal("images/carrot.png"));
		
		box=new Rectangle(MathUtils.random(Gdx.graphics.getWidth()),MathUtils.random(Gdx.graphics.getHeight()),texture.getWidth(),texture.getHeight());
		
		//time=0;
	}
	
	@Override
	public void render(float deltaTime) {
		// TODO Auto-generated method stub
		//time+=deltaTime;
		//System.out.println(time);
	}

	@Override
	public int getCharType() {
		// TODO Auto-generated method stub
		return charType;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		box.x=x;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return box.x;
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		box.y=y;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return box.y;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		texture.dispose();
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return box;
	}
	
	public void setEaten(boolean eaten){
		this.eaten=eaten;
	}
	
	public boolean isEaten(){
		return eaten;
	}
	
	

}
