package com.mc.oop.a_encapsulation.method;

public class SpringConcert {

	public void start() {
		System.out.println("Spring concert 시작합니다. ^^ ******");
		Player player = new Player("바이올린");
		player.play();
		System.out.println("=====================================");
	}
	
}
