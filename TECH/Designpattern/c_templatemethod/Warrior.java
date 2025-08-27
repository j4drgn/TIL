package com.mc.oop.c_templatemethod;

import java.util.Random;

/**
 * Warrior 클래스 - Character 추상 클래스를 상속받아 전사 캐릭터 구현
 * 전사는 높은 공격력과 방어력을 가진 캐릭터입니다.
 */
public class Warrior extends Character {
    
    private Random random = new Random();
    
    /**
     * Warrior 생성자
     * @param name 캐릭터 이름
     * @param hp 최대 체력
     * @param atk 기본 공격력
     * @param def 기본 방어력
     */
    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    /**
     * 전사의 방어 가중치 계산 메서드
     * 전사는 damage의 30%를 감소시킨 후 방어 가중치를 적용합니다.
     */
    @Override
    protected int calDefenseWeight(int damage) {
        // 30% 데미지 감소 후 방어력 적용
        damage = (int)(damage * 0.7);
        return damage - (damage * def/100);
    }

    /**
     * 전사의 공격 가중치 계산 메서드
     * 전사의 공격 가중치는 atk ~ atk * 4 사이의 랜덤 값입니다.
     */
    @Override
    protected int calAttackWeight() {
        return random.nextInt(atk, atk * 4);
    }
}
