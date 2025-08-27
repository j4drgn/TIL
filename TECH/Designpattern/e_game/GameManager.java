package com.mc.oop.e_game;

import java.util.Random;
import java.util.Scanner;

import com.mc.oop.e_game.character.Player;
import com.mc.oop.e_game.event.EventManager;
import com.mc.oop.e_game.event.MonsterEvent;

public class GameManager {
    private Player player;
    private EventManager eventManager;
    private int day;
    private int maxDays;
    private Scanner scanner;
    private Random random;
    private boolean gameOver;
    
    public GameManager(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
        this.eventManager = new EventManager();
        this.day = 1;
        this.maxDays = 8;
        this.gameOver = false;
    }
    
    public void initGame() {
        // 플레이어 생성
        player = new Player("용사", 200, 30, 10);
        
        // 이벤트 추가
        eventManager.addEvent(new MonsterEvent());
        
        System.out.println("텍스트로그라이크 게임을 시작합니다!");
    }
    
    public void runGameLoop() {
        while (!gameOver) {
            displayDayInfo();
            
            // 이벤트 확인 및 실행
            eventManager.checkAndExecuteEvents(player);
            
            // 하루에 하나의 이벤트가 무작위로 발생
            if (random.nextInt(100) < 50) { // 50% 확률
                eventManager.triggerRandomEvent(player);
            }
            
            // 플레이어 상태 확인
            checkPlayerStatus();
            
            // 다음 날로 진행
            if (!gameOver) {
                System.out.println("다음 날로 진행하려면 엔터를 누르세요.");
                scanner.nextLine();
                day++;
                
                // 모든 날짜 완료 확인
                if (day > maxDays) {
                    System.out.println("\n======================================");
                    System.out.println("[결과] 모험을 성공적으로 완료했습니다!");
                    gameOver = true;
                }
            }
        }
        
        System.out.println("\n게임이 종료되었습니다.");
    }
    
    private void displayDayInfo() {
        System.out.println("\n======================================");
        System.out.println("현재 " + day + "일차");
        System.out.println("[" + player.getName() + " HP]: " + player.getCurrentHp());
        System.out.println("======================================");
    }
    
    private void checkPlayerStatus() {
        if (player.isDead()) {
            System.out.println("\n======================================");
            System.out.println("[결과] LOSE - 플레이어가 사망했습니다.");
            gameOver = true;
        }
    }
}