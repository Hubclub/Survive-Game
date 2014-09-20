package com.hubclub.survive.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Zombie implements Poolable{
	
	private int code;//Used to identify the type of zombie
	/* 1-FirstZombie
	 * 2-IntelligentZombie
	 * 3-XIntelligentZombie
	 * 4-TravelerZombie
	 * 5-XTrevelerZombie
	 */
	private FirstZombie zombie1;
	private IntelligentZombie zombie2;
	private XIntelligentZombie zombie3;
	private TravelerZombie zombie4;
	private XTravelerZombie zombie5;
	
	public Zombie(int code,Bunny bunny){
		this.code=code;
		switch(code){
		case 1:
			zombie1=new FirstZombie();
			break;
		case 2:
			zombie2=new IntelligentZombie(bunny);
			break;
		case 3:
			zombie3=new XIntelligentZombie(bunny);
			break;
		case 4:
			zombie4=new TravelerZombie(bunny);
			break;
		case 5:
			zombie5=new XTravelerZombie(bunny);
		}

	}
	
	

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	public Object getObject(){
		return zombie1;
	}
	
	public Rectangle getRectangle(){
		switch(code){
		case 1:
			return zombie1.getRectangle();
		case 2:
			return zombie2.getRectangle();
		case 3:
			return zombie3.getRectangle();
		case 4:
			return zombie4.getRectangle();
		case 5:
			return zombie5.getRectangle();
		default: return null;
		}
	}
	
	public void draw(SpriteBatch batch){
		switch(code){
		case 1:
			batch.draw(zombie1.getTexture(),zombie1.getX(),zombie1.getY(),zombie1.getRectangle().width,zombie1.getRectangle().height);break;
		case 2:
			batch.draw(zombie2.getTexture(),zombie2.getX(),zombie2.getY(),zombie2.getRectangle().width,zombie2.getRectangle().height);break;
		case 3:
			batch.draw(zombie3.getTexture(),zombie3.getX(),zombie3.getY(),zombie3.getRectangle().width,zombie3.getRectangle().height);break;
		case 4:
			batch.draw(zombie4.getTexture(),zombie4.getX(),zombie4.getY(),zombie4.getRectangle().width,zombie4.getRectangle().height);break;
		case 5:
			batch.draw(zombie5.getTexture(),zombie5.getX(),zombie5.getY(),zombie5.getRectangle().width,zombie5.getRectangle().height);break;
		}
		
	}
	
	public void render(float delta){
		switch(code){
			case 1:zombie1.render(delta);break;
			case 2:zombie2.render(delta);break;
			case 3:zombie3.render(delta);break;
			case 4:zombie4.render(delta);break;
			case 5:zombie5.render(delta);break;
		}
		
	}
	

}
