package Queue;

import java.util.Arrays;

public class PriorityQueueMain {
	public static void main(String[] args) {
		var pq = new PriorityQueue(5);
		
		pq.enqueue(10);
		pq.enqueue(30);
		pq.enqueue(20);
		pq.enqueue(5);
		pq.print();
		
	}
}


class PriorityQueue{
	private int[] queue;
	
	int size = 0;
	
	public PriorityQueue(int capacity) {
		queue = new int[capacity];
	}
	
	public void enqueue(int item) {
		if(size == 0) {
			queue[size++] = item;
			return;
		}
		
		for(int i = size; i >= 0; i--) {
				
			if ((i != 0) && queue[i-1] > item) 
				queue[i] = queue[i-1];
			else {
				queue[i] = item;
				size++;
				break;
			}
		}	
	}
	
	public void print() {
		System.out.println(Arrays.toString(queue));
	}
	
}