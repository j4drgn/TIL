package com.mc.oop.e_game.item;

import java.util.Random;

public class Equipment implements DamageWeight {
	
	private String name;
	private int atk;
	private int def;
	private Slot slot;
	private String effect;
	private Random random = new Random();

	public Equipment(String name, int atk, int def, Slot slot, String effect) {
		super();
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.slot = slot;
		this.effect = effect;
	}

	@Override
	public int calAttackWeight(int damage) {
		return random.nextInt(damage + atk, damage + atk * 2);
	}

	@Override
	public int calDefenceWeight(int damage) {
		return damage - (damage * def/100);
	}

	public Slot getSlot() {
		return this.slot;
	}

	public String getEffect() {
		return effect;
	}

	public String getName() {
		return name;
	}
}
