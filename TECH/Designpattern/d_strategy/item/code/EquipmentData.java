package com.mc.oop.d_strategy.item.code;

import com.mc.oop.d_strategy.item.Equipment;
import com.mc.oop.d_strategy.item.Slot;

public enum EquipmentData {
	
	BASIC_WEAPON("주먹", 1, 1, Slot.WEAPON, "주먹을 휘두릅니다."),
	WOOD_SWORD("목검", 10, 1, Slot.WEAPON, "목검을 휘두릅니다."),
	WOOD_AXE("나무도끼", 10, 1, Slot.WEAPON, "나무도끼를 휘두릅니다."),
	KATANA("카타나", 30, 1, Slot.WEAPON, "쉭쉭"),
	
	WOOD_ARMOR("나무갑옷",1,10,Slot.ARMOR, ""),
	WOOD_BOOTS("나무부츠",1,5,Slot.BOOTS, ""),
	STON_ARMOR("돌갑옷",1,20,Slot.ARMOR, "");
	
	private String name;
	private int atk;
	private int def;
	private Slot slot;
	private String effect;
	
	private EquipmentData(String name, int atk, int def, Slot slot, String effect) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.slot = slot;
		this.effect = effect;
	}
	
	public Equipment create() {
		return new Equipment(name, atk, def, slot, effect);
	}
	

}
