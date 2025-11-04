package com.mc.algorithm.d_datastructure.stack;

public class Run {

	public static void main(String[] args) {
		System.out.println(isPair("{(멀티)[캠]{퍼}(스)}")); // true
		System.out.println(isPair("{{{{{{(]]멀티)[캠]{퍼}(스)}"));
		System.out.println(isPair("{{(]]}멀티)[캠]{퍼}(스)}))))"));
		
		System.out.println('(' + ')'); // 81
		System.out.println('[' + ']'); // 184
		System.out.println('{' + '}'); // 248
	}

	private static boolean isPair(String text) {
		_Stack<Character> stack = new _Stack<Character>();
		
		for (char ch : text.toCharArray()) {
			
			if("({[".contains(String.valueOf(ch))) {
				stack.push(ch);
				continue;
			};
			
			if(!")}]".contains(String.valueOf(ch))) continue;
			if(stack.isEmpty()) return false;
			int k = stack.pop();
			if(ch + k != 81 && ch + k != 184 && ch + k != 248) return false;
		}
		
		return stack.isEmpty();
	}

}
