package com.hubclub.survive.helpers;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.Carrot;
import com.hubclub.survive.characters.Zombie;
public class Collision {
	private Array<Zombie> zombies;
	private Bunny bunny;
	private Array<Carrot> powerups;
	
	public Collision(){
		
	}
	
	public void setBunny(Bunny bunny){
		this.bunny=bunny;
	}
	
	public void setZombies(Array<Zombie> zms){
		zombies=zms;
	}
	
	public void setPowerups(Array<Carrot> array){
		powerups=array;
	}
	
	public void detectCollisions(){
		for(Zombie zm:zombies){
			if(bunny.getRectangle().overlaps(zm.getRectangle())){
				if(bunny.isOnRampage())
					System.out.println("zombie disappeared");
				else 
					System.out.println("bunny takes damage");
			}
		}
		
		for(Carrot carrot : powerups){
			if(bunny.getRectangle().overlaps(carrot.getRectangle())){
				carrot.setEaten(true);
			}
		}
		
		
	}
}