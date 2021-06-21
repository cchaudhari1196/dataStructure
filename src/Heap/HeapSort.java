package Heap;

import java.util.Arrays;

public class HeapSort {
	public static void main(String args[]) {
		int[] items = {15,25,2,78,56,89};
		
		var heap = new HeapC();
		for(int item : items) {
			heap.insert(item);
		}
		
		for(int i = 0; i < items.length; i++) {
			items[i] = heap.remove();
		}
		
		System.out.println(Arrays.toString(items));
	}
}