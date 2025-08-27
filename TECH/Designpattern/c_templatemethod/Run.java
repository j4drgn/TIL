package com.mc.oop.c_templatemethod;

import java.util.Scanner;

// TemplateMethod 패턴 : 상속을 이용
// 다형성을 사용한 설계를 위해 인터페이스(public mehotd)를 재사용하는 경우
// 컴파일 시점에 변경되는 로직이 결정이 된다. (early binding, static binding)
public class Run {
	
	// Player 캐릭터의 공격 가중치 	 : atk/2 ~ atk * 3
	// Monster 의 공격 가중치		 : atk ~ atk * 2
	// Warrior 캐릭터의 공격 가중치  : atk ~ atk * 4
	//		            방어 가중치  : damage의 30% 를 감소시킨 후 방어 가중치 적용 
	// Thief 캐릭터의 공격 가중치	 : atk/2 ~ atk * 5
	// 								   50% 확률로 적의 공격을 무효화 한다
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Character player = new Thief("지존짱짱맨", 200, 30, 10);
		Character monster = new Monster("슬라임", 200, 30, 10);
		
		System.out.println("[전투이벤트] " + monster.getName() + " 등장!");
		
		while(true) {
			if(player.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] LOSE");
				break;
			}
			
			if(monster.isDead()) {
				System.out.println("\n======================================");
				System.out.println("[결과] WIN");
				break;
			}
			
			System.out.println("\n======================================");
			sc.nextLine();
			
			player.attack(monster);
			monster.attack(player);
			System.out.println("------------------------------------");
			System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
			System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
		}
		
	}

}
