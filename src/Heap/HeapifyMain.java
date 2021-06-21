package Heap;

import java.util.Arrays;

public class HeapifyMain {
	public static void main(String[] args) {
		
		int[] items =
			{15, 10, 3, 8, 12, 9, 4, 1, 24}; //Failes for this case.
//		{5,3,8,4,1,2};
		HeapifyMain heapify = new HeapifyMain();
		heapify.heapify(items);
		System.out.println(Arrays.toString(items));
	}

	
	/*My Solution- nOt working for ablove mentioned pb*/
//	private int[] items;
//	
//	private int[] heapify(int[] items) {
//		this.items = items;
//		for(int i = 0; i < items.length; i++) {
//			bubbleDown(i);
//		}
//		return this.items;
//	}
//	
//	private void bubbleDown(int index) {
//		
//		var whileIndex = 0;
//		while(index < items.length) {
//			int greaterChildIndex = index;
//			if (!isValidParent(index)) {
//				greaterChildIndex = (leftChild(index) > items[index])
//						? leftChildIndex(index) :	rightChildIndex(index);
//										
//				swap(index, greaterChildIndex);
//			}
//			else {
//				return;
//			}
//			index = greaterChildIndex;
//		}
//	}
//	
//	private int getParentIndex(int index) {
//		return (index - 1) / 2;
//	}
//	
//	private boolean isValidParent( int index) {
//		if ( !hasLeftChild(index))
//			return true;
//		if (!hasRightChild(index))
//			return leftChild(index) <= items[index];
//					
//		return leftChild(index) <= items[index] && rightChild(index) <= items[index];
//	}
//	
//	private void swap(int firstIndex, int secondIndex) {
//		var temp = items[firstIndex];
//		items[firstIndex] = items[secondIndex];
//		items[secondIndex] = temp;
//	}
//	
//	private boolean hasLeftChild(int index) {
//		return leftChildIndex(index) < items.length;
//	}
//	
//	private boolean hasRightChild(int index) {
//		return rightChildIndex(index) < items.length;
//	}
//	
//	private int leftChildIndex(int index) {
//		return (index * 2) + 1;
//	}
//	
//	private int rightChildIndex(int index) {
//		return (index * 2) + 2;
//	}
//	
//	private int leftChild(int index) {
//		return items[leftChildIndex(index)];
//	}
//	
//	private int rightChild(int index) {
//		return items[rightChildIndex(index)];
//	}
	
	
	private void heapify( int[] items) {
		int lastParent = items.length / 2 - 1;
		for (int i = lastParent; i >= 0; i--) {
			heapify(items, i);
		}
		
	}
	
	private void heapify(int[] items, int index) {
		var largestIndex = index;
		
		var leftIndex = (index * 2) + 1;
		if (leftIndex < items.length && items[index] < items[leftIndex]) {
			largestIndex = leftIndex;
		}
		
		var rightIndex = (index * 2) + 2;
		if (rightIndex < items.length && items[index] < items[rightIndex]) {
			largestIndex = rightIndex;
		}
		
		if (index == largestIndex) {
			return;
		}
		
		swap(index, largestIndex, items);
		heapify(items, largestIndex);
	}
	
	private void swap(int firstIndex, int secondIndex, int[] items) {
		var temp = items[firstIndex];
		items[firstIndex] = items[secondIndex];
		items[secondIndex] = temp;
	}
	
	
}

