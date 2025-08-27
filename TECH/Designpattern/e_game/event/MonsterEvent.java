package com.mc.oop.e_game.event;

import java.util.Random;
import java.util.Scanner;

import com.mc.oop.e_game.character.Monster;
import com.mc.oop.e_game.character.Player;

public class MonsterEvent implements Event {
    
    private Random random = new Random();
    private boolean executed = false;
    private Monster monster;
    private Scanner scanner;
    
    public MonsterEvent() {
        // 기본 몬스터 생성
        this.monster = new Monster("슬라임", 200, 30, 10);
    }
    
    @Override
    public boolean checkCondition(Player player) {
        // 랜덤하게 발생하는 이벤트로 변경
        return random.nextInt(100) < 30 && !executed; // 30% 확률
    }
    
    @Override
    public void execute(Player player) {
        System.out.println("[전투이벤트] " + monster.getName() + " 등장!");
        
        // 전투 시작
        startBattle(player);
        
        executed = true;
    }
    
    private void startBattle(Player player) {
        scanner = new Scanner(System.in);
        boolean battleOver = false;
        
        while (!battleOver) {
            System.out.println("\n======================================");
            System.out.println("엔터를 누르면 공격합니다.");
            scanner.nextLine(); // 사용자 입력 대기 (엔터만 누르면 진행)
            
            // 플레이어 공격
            player.attack(monster);
            
            // 몬스터가 죽었는지 확인
            if (monster.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] 몬스터를 물리쳤습니다!");
                battleOver = true;
                break;
            }
            
            // 몬스터 공격
            monster.attack(player);
            
            // 플레이어가 죽었는지 확인
            if (player.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] 플레이어가 패배했습니다.");
                battleOver = true;
                break;
            }
            
            System.out.println("------------------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }
    
    @Override
    public String getDescription() {
        return "몬스터와 전투 이벤트";
    }
    
    public Monster getMonster() {
        return monster;
    }
}
