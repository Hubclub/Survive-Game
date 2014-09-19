package com.hubclub.survive.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hubclub.survive.Constants;
import com.hubclub.survive.Survive;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.FirstZombie;
import com.hubclub.survive.characters.IntelligentZombie;

public class GameScreen implements Screen {
	
	private Survive game; // variable used to change the screen
	private Bunny bunny;
	private IntelligentZombie fzombie1;
	private FirstZombie fzombie2;
	private FirstZombie fzombie3;
	private FirstZombie fzombie4;
	
	private double startTime, endTime;
	
	private SpriteBatch batch;
	private OrthographicCamera viewCam;
	// This constructor is used instead of show method, because we need to 
	// pass the game variable into our class
	
	public GameScreen(Survive game) {
		this.game = game;
		
		viewCam = new OrthographicCamera();
		viewCam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		
		bunny = new Bunny();
		
		fzombie1 = new IntelligentZombie(bunny);
		fzombie2 = new FirstZombie();
		fzombie3 = new FirstZombie();
		fzombie4 = new FirstZombie();
		
	}// END OF CONSTRUCTOR
	
	public void render(float delta) {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		if(Gdx.app.getType() == ApplicationType.Desktop)
			Gdx.input.setInputProcessor(bunny.new BunnyDesktopInputProcessor());
		else if(Gdx.app.getType() == ApplicationType.Android) 
			Gdx.input.setInputProcessor(bunny.new BunnyAndroidInputProcessor());
		
		batch.setProjectionMatrix(viewCam.combined);
		batch.begin();
		batch.draw(bunny.getTexture(), bunny.getX(), bunny.getY(), bunny.getTexture().getWidth() * Constants.WIDTH_SCALE, bunny.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		
		batch.draw(fzombie1.getTexture(), fzombie1.getX(), fzombie1.getY(), fzombie1.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie1.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		batch.draw(fzombie2.getTexture(), fzombie2.getX(), fzombie2.getY(), fzombie2.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie2.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		batch.draw(fzombie3.getTexture(), fzombie3.getX(), fzombie3.getY(), fzombie3.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie3.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		batch.draw(fzombie4.getTexture(), fzombie4.getX(), fzombie4.getY(), fzombie4.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie4.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		
		batch.end();
		
		bunny.render(delta);
		fzombie1.render(delta);
		fzombie2.render(delta);
		fzombie3.render(delta);
		fzombie4.render(delta);
		
	}// END OF render METHOD
	
	public void resize(int width, int height) {
		
		viewCam.setToOrtho(false, width, height);
		
	}// END OF resize METHOD
	
	public void pause() {
		
	}// END OF pause METHOD
	
	public void resume() {
		
	}// END OF resume METHOD
	
	public void show() {
		
	}// END OF show METHOD
	
	public void hide() {
		
	}// END OF hide METHOD
	
	public void dispose() {
		
		bunny.dispose();
		
	}// END OF dispose METHOD
	
}// END OF GameScreen CLASS
