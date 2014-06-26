package com.beltonp.androidgame.fantasygame;

public class Character {
	
	int level;
	int experience;
	
	int health;
	int mana;
	
	int strength;
	int defence;
	int charisma;
	int agility;
	int speed;

	public Character() {
		this.level = 1;
		this.experience = 0;
		this.health = 50;
		this.mana = 0;
		
		this.strength = 10;
		this.defence = 10;
		this.charisma = 10;
		this.agility = 10;
		this.speed = 10;
	}
}
