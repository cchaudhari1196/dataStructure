package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class CustomStackMain {
	public static void main(String[] args) {
		CustomStack cs = new CustomStack();
		cs.push(10);
		cs.push(30);
		cs.push(20);
		cs.pop();
		cs.print();
	}
}


class CustomStack{
	
	private int[] stack = new int[2];
	private int size = 0;
	
	public int pop() {
		if(isEmpty()) throw new EmptyStackException();

		int value = stack[size-1];
		stack[size-1] = 0;
		size--;
		return value;
	}
	
	public int peek() {
		return  stack[size-1];
	}
	
	public void push(int item) {
		if(stack.length == size) {
			int[] arrayNew = new int[size*2];
			System.arraycopy(stack, 0, arrayNew, 0, size);
			stack = arrayNew;
		}
		stack[size++] = item;
	}
	
	public Boolean isEmpty() {
		return size == 0;
	}
	
	public int[] toArray() {
		int[] arrayNew = new int[size];
		System.arraycopy(stack, 0, arrayNew, 0, size);
		return arrayNew;
	}
	
	public void print() {
		System.out.println("Stack: "+ Arrays.toString(this.toArray()));
		System.out.println("Size: "+ size);
		System.out.println("Capacity: "+ stack.length);
	}
}