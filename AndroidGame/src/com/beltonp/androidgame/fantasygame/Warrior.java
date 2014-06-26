package com.beltonp.androidgame.fantasygame;

import java.util.Random;

public class Warrior extends Character {
	
	public Warrior() {
		super();
	}

	public void attack(Enemy enemy) {
		Random r = new Random();
		enemy.health -= r.nextInt((int)(float)(this.strength*110/100) - (int)(float)(this.strength*90/100) + 1) + (int)(float)(this.strength*90/100) ;
	}
}
