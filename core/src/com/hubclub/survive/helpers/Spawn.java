package com.hubclub.survive.helpers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.hubclub.survive.characters.Bunny;
import com.hubclub.survive.characters.Carrot;
import com.hubclub.survive.characters.Zombie;

public class Spawn {
	private Pool<Zombie> zombiePool = new Pool<Zombie>(){
		@Override
		protected Zombie newObject(){
			return new Zombie();
		}
	};
	private int score,level,max;
	private Array<Zombie> zombies;
	private Bunny bunny;
	//private Carrot carrot;

	
	public Spawn(){
		
	}
	
	public void set(Array<Zombie> zombies,Bunny bunny,int score){
		this.zombies=zombies;
		this.bunny=bunny;
		this.score=score;
	}
	
	public void spawn(){
		if(score<500){
			level=1;
			max=3;
		}
		else{
			if(score<1200){
				level=2;
				max=3;
			}
			else{
				if(score<2000){
					level=3;
					max=4;
					}
				else{
					if(score<3000){
						level=4;
						max=4;
					}
					
					else{
						if(score<4500){
							level=5;
							max=5;
						}
						else {
							level=6;
							max=6;
						}
					}
				}
				
			}
		}
		
		
		if(zombies.size<max){
			Zombie zm=zombiePool.obtain();
			zm.init(MathUtils.random(Math.max(0, 20*(level-2)),Math.min(100,level*20)), bunny);
			zombies.add(zm);
		}
		
		
	}
	
	public void deleteZombie(Zombie zm){
		zombies.removeValue(zm, true);
		zombiePool.free(zm);
	}
}
