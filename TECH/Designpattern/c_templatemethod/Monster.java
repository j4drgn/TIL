package com.mc.oop.c_templatemethod;

import java.util.Random;

public class Monster extends Character{

	public Monster(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	protected int calDefenseWeight(int damage) {
		return damage - (damage * def/100);
	}

	// Monster 의 공격 가중치는 atk ~ atk * 2
	@Override
	protected int calAttackWeight() {
		Random random = new Random();
		return random.nextInt(atk, atk * 2);
	}

}
