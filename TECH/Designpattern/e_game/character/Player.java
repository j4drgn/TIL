package com.mc.oop.e_game.character;

import java.util.Optional;
import java.util.Random;

import com.mc.oop.e_game.item.Equipment;
import com.mc.oop.e_game.item.Equipments;
import com.mc.oop.e_game.item.Slot;
import com.mc.oop.e_game.item.code.EquipmentData;

public class Player extends Character {
	
	private Random random = new Random();
	private Equipments equipments = new Equipments();

	public Player(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	public void attack(Character target) {
		int damage = random.nextInt(atk, atk * 3);
		
		System.out.println("[" + name + "] 공격!");
		for(Equipment e : equipments.findAll()) {
			damage = e.calAttackWeight(damage);
		}
		
		Optional<Equipment> optional = equipments.findBySlot(Slot.WEAPON);
		
		if(optional.isPresent()) {
			System.out.println(optional.get().getEffect()); 
		}
		
		target.takeDamage(damage);
	}

	@Override
	public void takeDamage(int damage) {
		// 피해량 연산
		for(Equipment e : equipments.findAll()) {
			damage = e.calDefenceWeight(damage);
		}
		System.out.println("[ Damage ] :" + damage);
		
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
	}

	public void equip(Equipment equipment) {
		equipments.equip(equipment);
	}
	
	// 체력 회복 메서드 추가
	public void heal(int amount) {
		this.currentHp += amount;
		this.currentHp = Math.min(currentHp, hp); // 최대 체력을 넘지 않도록
		System.out.println("[" + name + "] HP가 " + amount + "만큼 회복되었습니다.");
		System.out.println("현재 HP: " + currentHp);
	}
}
