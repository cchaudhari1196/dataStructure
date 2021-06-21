package Heap;

public class PriorityQueueWithHeap {
	
	public static void main(String[] args) {
		var pq = new PriorityQueueWithHeap();
		pq.enqueue(15);
		pq.enqueue(7);
		pq.enqueue(47);
		pq.enqueue(89);
		pq.enqueue(23);
	}
	
	private Heap heap = new Heap();
	
	public void enqueue(int item) {
		heap.insert(item);
	}
	
	public int dequeue() {
		return heap.remove();
	}
}
