package com.mc.oop.i_proxy;

public class DeveloperProxy implements Developer{

	private Developer developer;
	
	public DeveloperProxy(Developer developer) {
		super();
		this.developer = developer;
	}

	@Override
	public void develop() {
		System.out.println("[system] 출근 카드를 찍는다.");
		
		try {
			// 핵심로직
			developer.develop();
		} catch (Exception e) {
			System.out.println("앗 쉬는 날이었다.");
		}finally {
			System.out.println("집에 간다.");
		}
	}
}
