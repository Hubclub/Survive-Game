package com.hubclub.survive.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public interface Character {
	
	public void render(float deltaTime);
	public int getCharType();
	public void setX(float x);
	public float getX();
	public void setY(float y);
	public float getY();
	public void dispose();
	public Texture getTexture();
	public Rectangle getRectangle();
}
