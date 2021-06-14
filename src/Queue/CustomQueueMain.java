package Queue;

import java.util.Arrays;

public class CustomQueueMain {

	public static void main(String[] args) {
		var aq = new ArrayQueue(4);
		aq.enqueue(10);
		aq.enqueue(20);
		aq.enqueue(30);
		aq.enqueue(40);
		aq.print();
		System.out.println("Deque: "+aq.dequeue());
		aq.print();
		System.out.println("Deque: "+aq.dequeue());
		aq.print();
		System.out.println("Deque: "+aq.dequeue());
		aq.print();
		aq.enqueue(40);
		aq.enqueue(50);
		aq.enqueue(60);
		aq.print();
		System.out.println("Deque: "+aq.dequeue());
		aq.print();

	}

}


/*
 *Que: Create Custom Queue using Array of specified Capacity.
 * Similar to ArrayDeque(double ended queue)
 * 
 * 
 * 
 * 
 */
class ArrayQueue{

	private int[] queue;
	
	private int front = 0;
	private int rear = 0;
	
	/*
	 * For to count how many places are empty in array*/
	private int count = 0; 
	
	public ArrayQueue(int capacity) {
		this.queue = new int[capacity];
	}

	
	public void enqueue(int element) {
		if(queue.length == count )
			throw new IllegalStateException();

		/*
		 * Create a Circular queue, So that, 
		 * After dequeuing first elementm We can again use that Memory space to add other values.
		 *  Refer Mosh vdo or Notes.
		 */
		rear = rear % queue.length;
		
		
		queue[rear++] = element;
		count++;
	}
	
	public int dequeue() {
		var val = queue[front];
		
		/*
		 * Create a Circular queue, So that, 
		 * After dequeuing first elementm We can again use that Memory space to add other values.
		 *  Refer Mosh vdo or Notes.
		 */
		front =(front %  queue.length);
	
		
		queue[front++] = 0;
		count--;
		return val;
	}
	
	public void print() {
		
		System.out.println(Arrays.toString(queue));
	}
	
}
