package com.hubclub.survive;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.hubclub.survive.screens.MainMenuScreen;

public class Survive extends Game {
	
	public void create() {
		
		this.setScreen(new MainMenuScreen(this));
		
	}
	
	public void render() {
		
		super.render();
	}
	
	public void resize(int width, int height) {
		
		super.resize(width, height);
	}
	
	public void pause() {
		
		super.pause();
	}
	
	public void resume() {
		
		super.resume();
	}
	
	public void dispose() {
		
		super.dispose();
	}
	
} // END OF Survive CLASS