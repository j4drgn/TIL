package com.mc.oop.e_game.event;

import java.util.Random;

import com.mc.oop.e_game.character.Player;

public class HealEvent implements Event {
    
    private Random random = new Random();
    private boolean executed = false;
    
    @Override
    public boolean checkCondition(Player player) {
        // 매 턴마다 일정 확률로 발생
        return random.nextInt(100) < 30 && !executed; // 30% 확률
    }
    
    @Override
    public void execute(Player player) {
        int healAmount = random.nextInt(10, 30);
        System.out.println("HP를 " + healAmount + " 회복했습니다!");
        
        // Player 클래스의 heal 메서드 사용
        player.heal(healAmount);
        
        executed = true;
    }
    
    @Override
    public String getDescription() {
        return "체력 회복 이벤트";
    }
}
