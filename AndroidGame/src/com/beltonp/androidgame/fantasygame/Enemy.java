package com.beltonp.androidgame.fantasygame;

import java.util.Random;

public class Enemy {
	
	int health;
	int strength;
	
	public Enemy() {
		this.health = 20;
		this.strength = 15;
	}
	
	public  void attack(Character character)
	{
		Random r = new Random();
		character.health -= r.nextInt((int)(float)(this.strength*110/100) - (int)(float)(this.strength*90/100) + 1) + (int)(float)(this.strength*90/100) ;
	}
}
