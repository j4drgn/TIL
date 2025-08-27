package com.mc.oop.c_templatemethod;

import java.util.Random;

public class Thief extends Character{
	
	private Random random = new Random();
	
	public Thief(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	protected int calDefenseWeight(int damage) {
		if(random.nextInt(0, 2) == 0) {
			System.out.println("[Thief 특성 발동]  공격이 빗나갑니다.");
			return 0;
		}
		return damage - (damage * def/100);
	}

	// Thief 캐릭터의 공격 가중치는 atk/2 ~ atk * 5
	@Override
	protected int calAttackWeight() {
		return random.nextInt(atk/2, atk * 5);
	}

}
