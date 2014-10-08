package com.hubclub.survive.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hubclub.survive.Constants;
import com.hubclub.survive.Survive;

public class MainMenuScreen implements Screen{
	
	private final Survive game;
	private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
	
	public MainMenuScreen(Survive game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        spriteBatch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("FOO-64.fnt"));
        font.setColor(Color.GREEN   );
        font.setScale(Constants.WIDTH_SCALE);
	}
	
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        spriteBatch.begin();

        font.draw(spriteBatch, "Survive", Gdx.graphics.getWidth() / 2 - font.getBounds("Survive").width / 2, Gdx.graphics.getHeight() / 2);

        spriteBatch.end();

		if(Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			this.dispose();
		}
	}
	
	public void resize(int width, int height) {
		
	}
	
	public void resume() {
		
	}
	
	public void pause() {
		
	}
	
	public void dispose() {
		
	}
	
	public void show() {
		
	}
	
	public void hide() {

	}
}// END OF MainMenuScreen CLASS
