package com.mc.oop.e_game.event;

import java.util.Random;

import com.mc.oop.e_game.character.Player;
import com.mc.oop.e_game.item.Equipment;
import com.mc.oop.e_game.item.code.EquipmentData;

public class TreasureEvent implements Event {
    
    private Random random = new Random();
    private boolean executed = false;
    
    @Override
    public boolean checkCondition(Player player) {
        // 플레이어의 HP가 150 미만일 때 발동
        return player.getCurrentHp() < 150 && !executed;
    }
    
    @Override
    public void execute(Player player) {
        EquipmentData[] datas = EquipmentData.values();
        int index = random.nextInt(0, datas.length);
        
        Equipment equipment = datas[index].create();
        System.out.println(equipment.getName() + " 발견했습니다.");
        player.equip(equipment);
        
        executed = true;
    }
    
    @Override
    public String getDescription() {
        return "보물상자 발견 이벤트";
    }
}
