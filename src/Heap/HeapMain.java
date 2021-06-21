package Heap;

public class HeapMain {
	public static void main(String[] args) {
		var heap = new HeapC();
		System.out.println();
//		heap.insert(10);
//		heap.print();
//		heap.insert(5);
//		heap.print();
//		heap.insert(17);
//		heap.print();
//		heap.insert(4);
//		heap.print();
//		heap.insert(22);
//		heap.print();
//		heap.insert(6);
//		heap.print();
//		heap.insert(7);
//		heap.print();
//		heap.insert(28);
//		heap.print();

		
		
		int[] listForTesting = {15, 10, 3, 8, 12, 9, 4, 1, 24};
		for( int item : listForTesting) {
			heap.insert(item);
		}
		heap.print();
		

		heap.remove();
		heap.print();
	}
}

/*This Class Is impl by me. (Used concurrency*/
class HeapC{
	private int[] array = new int[20];
	private int size = 0;
	
	public void insert(int item) {
		array[size] = item;
		bubbleUp(size);
		size++;
	}
	
	public int remove() {
		var root = array[0]; 
		array[0] = array[size-1];
		array[size - 1] = 0;
		bubbleDown(0);
		size--;
		return root;
	}
	
	private void bubbleUp(int childIndex) {
		var parentIndex = getParentIndex(childIndex);
		if(array[parentIndex] < array[childIndex]) {
			swap(childIndex, parentIndex);
		}	
		else {
			return;
		}
		bubbleUp(parentIndex);
	}
	
	private void bubbleDown(int parentIndex) {
		int targetIndex = parentIndex;
		if(!isValidParent(parentIndex)) {
			if(getFirstChild(parentIndex) < getSecondChild(parentIndex))
				targetIndex = getSecondChildindex(parentIndex);
			else if (getFirstChild(parentIndex) > getSecondChild(parentIndex))
				targetIndex = getFirstChildindex(parentIndex);
			
			swap(targetIndex, parentIndex);
		}else {
			return;
		}
		bubbleDown(targetIndex);
	}
	
	private boolean isValidParent(int index) {
		if(!hasFirstChild(index))
			return true;
		if(!hasSecondChild(index))
			return array[getFirstChildindex(index)] <= array[index];
		return array[getSecondChildindex(index)] <= array[index] 
				&& array[getFirstChildindex(index)] <= array[index];
	}
	
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
	
	private void swap(int first, int second) {
		var backup = array[first]; 
		array[first] = array[second];
		array[second] = backup;
	}
	
	private int getFirstChildindex(int index) {
		return (index * 2) + 1;
	}
	
	private int getFirstChild(int index) {
		return array[getFirstChildindex(index)];
	}
	
	private boolean hasFirstChild(int index) {
		return getFirstChildindex(index) <= size;
	}
	
	private boolean hasSecondChild(int index) {
		return getSecondChildindex(index) <= size;
	}
	
	private int getSecondChildindex(int index) {
		return (index * 2) + 2;
	}

	private int getSecondChild(int index) {
		return array[getSecondChildindex(index)];
	}
	
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
