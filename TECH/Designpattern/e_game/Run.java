package com.mc.oop.e_game;

import java.util.Scanner;

public class Run {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 게임 매니저 생성 및 초기화
        GameManager gameManager = new GameManager(sc);
        gameManager.initGame();
        
        // 게임 실행
        gameManager.runGameLoop();
        
        sc.close();
    }
}
