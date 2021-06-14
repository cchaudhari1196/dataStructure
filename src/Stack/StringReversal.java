package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StringReversal {
	
	public static void main(String[] args) {
		String name ="Chirag";
		
		System.out.println(reverse(name));
	}
	
	public static String reverse(String name) {
		Stack<Character> stack = new Stack<Character>();
//		Deque<Integer> stack = new ArrayDeque<Integer>();
		for(Character c : name.toCharArray()) {
			stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}

}
