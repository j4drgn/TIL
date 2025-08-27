package com.mc.oop.c_templatemethod;

import java.util.Random;

/**
 * Player 클래스 - Character 추상 클래스를 상속받아 플레이어 캐릭터 구현
 * 플레이어는 기본적인 공격과 방어 능력을 가진 캐릭터입니다.
 */
public class Player extends Character {
    
    private Random random = new Random();
    
    /**
     * Player 생성자
     * @param name 캐릭터 이름
     * @param hp 최대 체력
     * @param atk 기본 공격력
     * @param def 기본 방어력
     */
    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    /**
     * 플레이어의 방어 가중치 계산 메서드
     * 플레이어는 기본적인 방어력 계산을 사용합니다.
     */
    @Override
    protected int calDefenseWeight(int damage) {
        return damage - (damage * def/100);
    }

    /**
     * 플레이어의 공격 가중치 계산 메서드
     * 플레이어의 공격 가중치는 atk/2 ~ atk * 3 사이의 랜덤 값입니다.
     */
    @Override
    protected int calAttackWeight() {
        return random.nextInt(atk/2, atk * 3);
    }
}
