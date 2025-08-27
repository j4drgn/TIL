package com.mc.oop.c_templatemethod;

/**
 * Character 추상 클래스 - 템플릿 메서드 패턴의 핵심 클래스
 * 모든 캐릭터의 기본 속성과 행위를 정의하고, 일부 알고리즘 단계를 하위 클래스에 위임합니다.
 */
public abstract class Character {
	
	protected String name;    // 캐릭터 이름
	protected int hp;         // 최대 체력
	protected int currentHp;  // 현재 체력
	protected int atk;        // 기본 공격력
	protected int def;        // 기본 방어력
	
	/**
	 * Character 생성자
	 * @param name 캐릭터 이름
	 * @param hp 최대 체력
	 * @param atk 기본 공격력
	 * @param def 기본 방어력
	 */
	public Character(String name, int hp, int atk, int def) {
		super();
		this.name = name;
		this.hp = hp;
		this.currentHp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	/**
	 * 템플릿 메서드: 공격 알고리즘의 구조 정의
	 * 공격 가중치 계산은 하위 클래스에 위임합니다.
	 * @param target 공격 대상 캐릭터
	 */
	public void attack(Character target) {
		System.out.println("[" + name + "] 공격!");
		int damage = calAttackWeight();  // 하위 클래스에서 구현할 부분
		target.takeDamage(damage);
	}

	/**
	 * 템플릿 메서드: 피해 알고리즘의 구조 정의
	 * 방어 가중치 계산은 하위 클래스에 위임합니다.
	 * @param damage 받은 피해량
	 */
	public void takeDamage(int damage) {
		damage = calDefenseWeight(damage);  // 하위 클래스에서 구현할 부분
		System.out.println("[ Damage ] :" + damage);
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);  // 체력이 0 미만이 되지 않도록 보장
	}

	/**
	 * 방어 가중치 계산 메서드 - 하위 클래스에서 구현
	 * @param damage 원래 피해량
	 * @return 방어력이 적용된 최종 피해량
	 */
	protected abstract int calDefenseWeight(int damage);

	/**
	 * 공격 가중치 계산 메서드 - 하위 클래스에서 구현
	 * @return 공격력이 적용된 최종 공격량
	 */
	protected abstract int calAttackWeight();

	/**
	 * 캐릭터 이름 반환
	 * @return 캐릭터 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 현재 체력 반환
	 * @return 현재 체력
	 */
	public int getCurrentHp() {
		return currentHp;
	}
	
	/**
	 * 캐릭터 사망 여부 확인
	 * @return 체력이 0이면 true, 그렇지 않으면 false
	 */
	public boolean isDead() {
		return currentHp == 0;
	}
}
