package com.hubclub.survive.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.Constants;
import com.hubclub.survive.Survive;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.Carrot;
import com.hubclub.survive.characters.Zombie;
import com.hubclub.survive.helpers.Collision;
import com.hubclub.survive.helpers.Spawn;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen implements Screen {
	
	private Survive game; // variable used to change the screen
	private Bunny bunny;
	private Carrot carrot;
	private Collision col;
	private Array<Zombie> zombies;
	private Spawn spawner;
	private double startTime, endTime;
	private int score;
	private SpriteBatch batch;
	private OrthographicCamera viewCam;
	private BitmapFont font;
	private ShapeRenderer shape;

    private Texture background;
	// This constructor is used instead of show method, because we need to 
	// pass the game variable into our class
	
	public GameScreen(Survive game) {
		this.game = game;
		
		shape = new ShapeRenderer();
		
		font=new BitmapFont(Gdx.files.internal("FOO-64.fnt"));
		font.setColor(Color.GREEN);
		font.setScale(Constants.WIDTH_SCALE*0.3f);
		
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
		shape.begin(ShapeType.Filled);
        //draw the background
		if(!bunny.isOnRampage())
			batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		else{
		
			Gdx.gl.glClearColor(getRandomColor().r,getRandomColor().g,getRandomColor().b,getRandomColor().a);
		//	shape.setColor(Color.RED);
			//shape.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		batch.draw(bunny.getTexture(), bunny.getX(), bunny.getY(), bunny.getRectangle().width, bunny.getRectangle().height);
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
		
		font.draw(batch, "Score:"+score, 0, Gdx.graphics.getHeight()-font.getCapHeight());
		//batch.draw(fzombie1.getTexture(), fzombie1.getX(), fzombie1.getY(), fzombie1.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie1.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie2.getTexture(), fzombie2.getX(), fzombie2.getY(), fzombie2.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie2.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie3.getTexture(), fzombie3.getX(), fzombie3.getY(), fzombie3.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie3.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		//batch.draw(fzombie4.getTexture(), fzombie4.getX(), fzombie4.getY(), fzombie4.getTexture().getWidth() * Constants.WIDTH_SCALE, fzombie4.getTexture().getHeight() * Constants.HEIGHT_SCALE);
		shape.end();
		batch.end();
	}
	
	private Color getRandomColor(){
		int rand = MathUtils.random(1, 3);
		switch(rand){
		case 1 : return Color.GREEN;
		case 2 : return Color.RED;
		case 3 : return Color.BLUE;
		default : return Color.WHITE;
		}
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
