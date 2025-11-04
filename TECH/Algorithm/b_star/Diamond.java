package com.mc.algorithm.b_star;

import java.util.Scanner;

/**
 * 다이아몬드 모양의 별 패턴을 출력하는 클래스
 * 
 * 사용자로부터 입력받은 숫자에 따라 다이아몬드 모양의 패턴을 출력합니다.
 * 패턴은 위쪽 부분(점점 커지는 삼각형)과 아래쪽 부분(점점 작아지는 역삼각형)으로 구성됩니다.
 */
public class Diamond {
	
	/**
	 * 메인 메소드 - 다이아몬드 모양의 별 패턴을 출력합니다.
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 사용자에게 입력 안내 메시지 출력
		System.out.print("입력 : ");		
		// 사용자로부터 정수 입력 받기
		int input = new Scanner(System.in).nextInt();
		
		// 다이아몬드의 위쪽 부분 출력 (위에서 아래로 커지는 삼각형)
		for (int i = 1; i < input + 1; i++) {
			// 앞쪽 공백 출력 (input - i개의 공백)
			// 행이 증가할수록 공백이 줄어듦
			for (int j = 0; j < input - i; j++) {
				System.out.print(" ");
			}
			
			// 별표 출력 (2 * i - 1개의 별표)
			// 행이 증가할수록 별표가 늘어남 (1, 3, 5, 7, ...)
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			
			// 한 행의 출력이 끝나면 줄바꿈
			System.out.println();
		}
		
		// 다이아몬드의 아래쪽 부분 출력 (아래로 갈수록 작아지는 역삼각형)
		for (int i = 0; i < input; i++) {
			// 앞쪽 공백 출력 (i개의 공백)
			// 행이 증가할수록 공백이 늘어남
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			// 별표 출력 (2 * (input - i) - 1개의 별표)
			// 행이 증가할수록 별표가 줄어듦
			for (int j = 0; j < 2 * (input - i) - 1; j++) {
				System.out.print("*");
			}
			
			// 한 행의 출력이 끝나면 줄바꿈
			System.out.println();
		}
	}
}
