package com.hubclub.survive.helpers;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.hubclub.survive.characters.Zombie;
public class Collision {
	private Array<Rectangle> zmBoxes;
	private Rectangle bunny;
	
	public Collision(){
		zmBoxes=new Array<Rectangle>();
	}
	
	public void setBunny(Rectangle bunny){
		this.bunny=bunny;
	}
	
	public void setZombies(Array<Zombie> zombies){
		for(Zombie zm : zombies){
			zmBoxes.add(zm.getRectangle());
		}
	}
	
	public void detectCollisions(){
		for(Rectangle box:zmBoxes){
			if(bunny.overlaps(box)){
				System.out.println("collision");
			}
		}
	}
}