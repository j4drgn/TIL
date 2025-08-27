package com.mc.oop.d_strategy.character;

import java.util.Random;

public class Monster extends Character{
	
	private Random random = new Random();

	public Monster(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	public void attack(Character target) {
		System.out.println("[" + name + "] 공격!");
		int damage = random.nextInt(atk, atk*2);
		target.takeDamage(damage);
	}

	@Override
	public void takeDamage(int damage) {
		damage = damage - (damage * def/100);
		System.out.println("[ Damage ] :" + damage);
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
	}
	
	

}
