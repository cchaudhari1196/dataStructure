package Heap;

public class HeapByMosh {
	public static void main(String args[]) {

		Heap heap = new Heap();
//		heap.insert(10);
//		heap.insert(5);
//		heap.insert(17);
		
		int[] listForTesting = {15, 10, 3, 8, 12, 9, 4, 1};
		for( int item : listForTesting) {
			heap.insert(item);
		}
//		heap.remove();
		heap.print();
	}
}

class Heap{
	private int[] items = new int[10];
	private int size = 0;
	
	public void insert(int item) {
		if(isFull())
			throw new IllegalStateException();
		items[size++] = item;
		
		bubbleUp();
	}
	
	public int remove() {
		if(isEmpty())
			throw new IllegalStateException();
		

		var root = items[0];
		items[0] = items[--size];
		bubbleDown();
		return root;
	}
	
	private void bubbleDown() {
		var index = 0;
		while(index <= size && !isValidParent(index)) {
			var greaterChildindex = getGreaterChildIndex(index);
			
			swap(index, greaterChildindex);
			index = greaterChildindex;
		}
	}
	
	public void print() {
		for(int item: items) {
			System.out.print(item +" ");
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int getGreaterChildIndex(int index) {
		/*Check if parent has the childs, if not, ten return proper int*/
		if(!hasLeftChild(index))
			return index; // Returned index, bacause in heap elements are filled from left to right. and if left is blank then there is no right
		if(!hasRightChild(index))
			return getLeftChildIndex(index);
		
		return (getLeftChild(index) > getRightChild(index)) ?
				getLeftChildIndex(index) :
					getRightChildIndex(index);
	}
	
	private boolean isValidParent(int index) {
		if(!hasLeftChild(index))
			return true; // Returned ture, bacause in heap elements are filled from left to right. and if left is blank then there is no right. So, No childs. So its valid heap parent.
		if(!hasRightChild(index))
			return items[index] >= getLeftChild(index);
		
		return items[index] >= getLeftChild(index) && items[index] >= getRightChild(index);
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) <= size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) <= size;
	}
	
	private int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int getRightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int getLeftChildIndex(int index) {
		return (index *2) + 1;
	}
	
	private int getRightChildIndex(int index) {
		return (index *2) + 2;
	}
	
	public boolean isFull() {
		return size == items.length;
	}
	
	private void bubbleUp() {
		var index = size - 1;
		while(index > 0 && items[getParentIndex(index)] < items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private void swap(int first, int second) {
		var temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}
	
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
}
