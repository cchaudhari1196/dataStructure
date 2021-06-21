package Heap;

public class KthLargestElementMain {
	public static void main(String[] args) {
		int[] items = {10, 25, 12, 89, 36};
		System.out.println(KthLargestElement.findKthLargest(2, items));;
	}
}

class KthLargestElement {
	 public static int findKthLargest(int k, int[] items) {
		 if (k > items.length || k <= 0)
			 throw new IndexOutOfBoundsException();
		 HeapC heap = new HeapC();
		 for(int i = 0; i < items.length; i++) {
			 heap.insert(items[i]);
		 }
		 
		 int kthLargest = items[0];
		 for (int i = 0; i < k; i++) {
			kthLargest = heap.remove();
		 }
		 return kthLargest;
	 }
}
