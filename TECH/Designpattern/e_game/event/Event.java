package com.mc.oop.e_game.event;

import com.mc.oop.e_game.character.Player;

public interface Event {
    boolean checkCondition(Player player);
    void execute(Player player);
    String getDescription();
}
