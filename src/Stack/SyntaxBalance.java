package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;



/* SYNTAX CHECKING/VLIDATING
 * Que -  Write a code to check if brackets are properly opended and closed in a string.
 * 
 */
public class SyntaxBalance {
	
	public static void main(String[] args) {
		String s = ")({({(asd)})} ({})";
		System.out.println(balance(s));
	}
	
	public static Boolean balance(String s) {
		
		Boolean isSyntaxRight = true;
		Stack<Character> stack = new Stack<Character>();
		List<Character> startBrackets = Arrays.asList('{','(','[','<');
		List<Character> endBrackets =  Arrays.asList('}',')',']','>');
		
		for(Character ch: s.toCharArray()) {
			if(!(endBrackets.contains(ch) || startBrackets.contains(ch))) {
				continue;
			}
			if(startBrackets.contains(ch)) {
				stack.push(ch);
			}
			else {
				if(stack.isEmpty() || !(startBrackets.indexOf(stack.pop()) == (endBrackets.indexOf(ch)))) {
					isSyntaxRight = false;
					break;
				}
			}
		}
		return isSyntaxRight;
	}
}
