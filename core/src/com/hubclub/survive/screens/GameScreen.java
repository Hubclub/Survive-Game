package com.hubclub.survive.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.Constants;
import com.hubclub.survive.Survive;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.Carrot;
import com.hubclub.survive.characters.FirstZombie;
import com.hubclub.survive.characters.IntelligentZombie;
import com.hubclub.survive.characters.TravelerZombie;
import com.hubclub.survive.characters.XIntelligentZombie;
import com.hubclub.survive.characters.XTravelerZombie;
import com.hubclub.survive.characters.Zombie;
import com.hubclub.survive.helpers.Collision;
import com.hubclub.survive.helpers.Spawn;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {
	
	private Survive game; // variable used to change the screen
	private Bunny bunny;
	private XIntelligentZombie fzombie1;
	private TravelerZombie fzombie2;
	private FirstZombie fzombie3;
	private FirstZombie fzombie4;
	private Carrot carrot;
	private Collision col;
	private Array<Zombie> zombies;
	private Spawn spawner;
	private double startTime, endTime;
	private int score;
	private SpriteBatch batch;
	private OrthographicCamera viewCam;

    private Texture background;
	// This constructor is used instead of show method, because we need to 
	// pass the game variable into our class
	
	public GameScreen(Survive game) {
		this.game = game;
		
		spawner=new Spawn();
		col=new Collision();
		viewCam = new OrthographicCamera();
		viewCam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		
		bunny = new Bunny();
		
		score =0;
		carrot=new Carrot();

        background = new Texture(Gdx.files.internal("images/road.jpg"));
	
		
		zombies=new Array<Zombie>();
		
		/* fzombie1 = new XIntelligentZombie(bunny);
		/* fzombie2 = new TravelerZombie(bunny);
		 * fzombie3 = new FirstZombie();
		 * fzombie4 = new FirstZombie();
		*/
		
	}// END OF CONSTRUCTOR
	
	public void render(float delta) {
		
		col.set(spawner,bunny,zombies,carrot);
		
		spawner.set(zombies,  bunny, score);
		spawner.spawn();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		if(Gdx.app.getType() == ApplicationType.Desktop)
			Gdx.input.setInputProcessor(bunny.new BunnyDesktopInputProcessor());
		else if(Gdx.app.getType() == ApplicationType.Android) 
			Gdx.input.setInputProcessor(bunny.new BunnyAndroidInputProcessor());
		
		draw();
		
		bunny.render(delta);
		//fzombie1.render(delta);
		//fzombie2.render(delta);
		carrot.render(delta);
		//fzombie3.render(delta);
		//fzombie4.render(delta);
		for(Zombie zm : zombies){
			zm.render(delta);
		}
		col.detectCollisions();
		
	}// END OF render METHOD
	
	public void draw(){
		batch.setProjectionMatrix(viewCam.combined);
		batch.begin();
        //draw the background
        batch.draw(background, 0, 0, Gdx.graphics.getWidth() * Constants.WIDTH_SCALE, Gdx.graphics.getHeight() * Constants.HEIGHT_SCALE);
        System.out.println("washere");
		batch.draw(bunny.getTexture(), bunny.getX(), bunny.getY(), bunny.getTexture().getWidth() * Constants.WIDTH_SCALE, bunny.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		if(!carrot.isEaten())
			batch.draw(carrot.getTexture(), carrot.getX(),carrot.getY(),carrot.getRectangle().width,carrot.getRectangle().height);
		else {
			bunny.setCarrotsEaten(bunny.getCarrotsEaten()+1);
			score+=100;
			carrot.dispose();
			carrot=new Carrot();
			System.out.println(score);
		}
		
		
		for(int i=0;i<zombies.size;i++){
			zombies.get(i).draw(batch);
		}
		
		//batch.draw(fzombie1.getTexture(), fzombie1.getX(), fzombie1.getY(), fzombie1.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie1.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie2.getTexture(), fzombie2.getX(), fzombie2.getY(), fzombie2.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie2.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie3.getTexture(), fzombie3.getX(), fzombie3.getY(), fzombie3.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie3.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie4.getTexture(), fzombie4.getX(), fzombie4.getY(), fzombie4.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie4.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		
		batch.end();
	}
	
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
