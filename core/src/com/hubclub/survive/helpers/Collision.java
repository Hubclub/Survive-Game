package com.hubclub.survive.helpers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.Carrot;
import com.hubclub.survive.characters.Zombie;

public class Collision {
	private Array<Zombie> zombies;
	private Bunny bunny;
	private Carrot carrot;
	private Spawn spawner;
	
	public Collision(){
		
	}
	
	public void set(Spawn spawner,Bunny bunny , Array<Zombie> zms, Carrot carrot){
		zombies=zms;
		this.bunny=bunny;
		this.carrot=carrot;
		this.spawner=spawner;
	}
	

	
	public void detectCollisions(){
		for(Zombie zm:zombies){
			if(bunny.getRectangle().overlaps(zm.getRectangle())){
				if(bunny.isOnRampage())
					spawner.deleteZombie(zm);
				else 
					System.out.println("bunny takes damage");
			}
		}
		
		
			if(bunny.getRectangle().overlaps(carrot.getRectangle())){
				carrot.setEaten(true);
		}
		
		
	}
}