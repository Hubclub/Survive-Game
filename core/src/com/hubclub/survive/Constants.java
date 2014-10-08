package com.hubclub.survive;

import com.badlogic.gdx.Gdx;

public class Constants {
	
	// I use this class because enum
	// is fucked up in java
	
	public static final float WIDTH_SCALE = (float)(Gdx.graphics.getWidth()) / 480;
	public static final float HEIGHT_SCALE = (float)(Gdx.graphics.getHeight()) / 760;
	public static final float BUNNY_HEIGHT=48*HEIGHT_SCALE;
	public static final float BUNNY_WIDTH=48*WIDTH_SCALE;
	public static final float CARROT_HEIGHT=24*HEIGHT_SCALE;
	public static final float CARROT_WIDTH=24*WIDTH_SCALE;
	public static final float ZOMBIE_WIDTH=64*WIDTH_SCALE;
	public static final float ZOMBIE_HEIGHT=64*HEIGHT_SCALE;
	
	
}// END OF Constants CLASS
