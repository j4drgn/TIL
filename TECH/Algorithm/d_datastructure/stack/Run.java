package com.mc.algorithm.d_datastructure.stack;

/**
 * 스택 구현체의 기능을 테스트하는 실행 클래스
 * 
 * 이 클래스는 사용자 정의 스택(_Stack) 구현체를 사용하여
 * 괄호 쌍 검사 알고리즘을 구현하고 테스트합니다.
 */
public class Run {

	/**
	 * 메인 메소드 - 괄호 쌍 검사 기능 테스트
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 다양한 문자열에 대한 괄호 쌍 검사 수행
		System.out.println(isPair("{(멀티)[캠]{퍼}(스)}")); // true
		System.out.println(isPair("{{{{{{(]]멀티)[캠]{퍼}(스)}")); // false
		System.out.println(isPair("{{(]]}멀티)[캠]{퍼}(스)}))))")); // false
		
		// 괄호 쌍의 ASCII 코드 합 출력 (isPair 메소드에서 사용됨)
		System.out.println('(' + ')'); // 81
		System.out.println('[' + ']'); // 184
		System.out.println('{' + '}'); // 248
	}

	/**
	 * 문자열 내의 괄호 쌍이 올바르게 짝지어져 있는지 확인하는 메소드
	 * 
	 * 이 메소드는 스택을 사용하여 여는 괄호를 저장하고, 닫는 괄호를 만날 때마다
	 * 스택에서 꺼낸 여는 괄호와 짝이 맞는지 확인합니다.
	 * ASCII 코드 합을 사용하여 괄호 쌍을 검증합니다.
	 * 
	 * @param text 검사할 문자열
	 * @return 모든 괄호가 올바르게 짝지어져 있으면 true, 그렇지 않으면 false
	 */
	private static boolean isPair(String text) {
		// 여는 괄호를 저장할 스택 생성
		_Stack<Character> stack = new _Stack<Character>();
		
		// 문자열의 각 문자를 순회
		for (char ch : text.toCharArray()) {
			
			// 여는 괄호인 경우 스택에 추가
			if("({[".contains(String.valueOf(ch))) {
				stack.push(ch);
				continue;
			};
			
			// 닫는 괄호가 아닌 경우 건너뜀
			if(!")}]".contains(String.valueOf(ch))) continue;
			// 닫는 괄호인데 스택이 비어있으면 짝이 맞지 않음
			if(stack.isEmpty()) return false;
			
			// 스택에서 여는 괄호를 꺼내고 닫는 괄호와 짝이 맞는지 확인
			int k = stack.pop();
			// ASCII 코드 합을 사용하여 괄호 쌍 검증
			if(ch + k != 81 && ch + k != 184 && ch + k != 248) return false;
		}
		
		// 모든 문자를 처리한 후 스택이 비어있어야 모든 괄호가 짝지어진 것
		return stack.isEmpty();
	}
}
