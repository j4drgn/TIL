package com.mc.oop.e_game.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mc.oop.e_game.character.Player;

public class EventManager {
    
    private List<Event> events = new ArrayList<>();
    private Random random = new Random();
    
    public EventManager() {
        // 기본 이벤트 등록
        events.add(new TreasureEvent());
        events.add(new HealEvent());
    }
    
    // 이벤트 추가
    public void addEvent(Event event) {
        events.add(event);
    }
    
    // 조건에 맞는 이벤트 실행
    public void checkAndExecuteEvents(Player player) {
        for (Event event : events) {
            if (event.checkCondition(player)) {
                event.execute(player);
            }
        }
    }
    
    // 랜덤 이벤트 발생
    public void triggerRandomEvent(Player player) {
        if (events.isEmpty()) return;
        
        int index = random.nextInt(events.size());
        Event event = events.get(index);
        
        if (event.checkCondition(player)) {
            event.execute(player);
        }
    }
}
