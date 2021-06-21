package BinaryTree;

public class BinaryTreeMain {
	
	public static void main(String[] args) {
		
		
		/**we will create following tree
		 * 
		 * 			7
		 * 		   /  \
		 * 		  4    9
		 *		/ \    / \	
		 * 	   1   6  8   10
		 * */ 
		var tree = new Tree();		
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);
		
		
		System.out.println(tree.find(5));
		
		tree.preOrderTransver();
		System.out.println("___________");
		tree.inOrderTransver();
		System.out.println("___________");
		tree.postOrderTraversal();
		
		
		System.out.println("Height of Root Node is");
		System.out.println(tree.height());
		
		System.out.println("Equals the two trees");
		var tree1 = new Tree();		
		tree1.insert(7);
		tree1.insert(5);
		tree1.insert(9);
		tree1.insert(1);
		tree1.insert(6);
		tree1.insert(8);
		tree1.insert(10);
		System.out.println("Eqauls by me: " + tree1.equalsC(tree));
		System.out.println("Equals by Mosh: "+ tree1.equals(tree));
		
		System.out.println("Is Tree Binary Search Tree");
//		tree.swapRoot();
		System.out.println(tree.isBST()+"\n\n\n");
		
		System.out.println("Print all K'th Node from Root");
		tree.printNodeAtKthNode(1);	
		
		System.out.println("Level Oder traversal");
		tree.levelOderTraversal();		
		
	}

}


class Tree{
		
	private Node root;
	
	
	public void insert(Integer item) {
		var node = new Node(item);
		
		Node currentNode = root;
		if(root == null) {
			root = node;
			return;
		}
		
		while( currentNode != null) {
			if(item > currentNode.value) {
				if(currentNode.rightChild == null) {
					currentNode.rightChild = node;
					break;
				}
				currentNode = currentNode.rightChild;
			}
			else {
				if(currentNode.leftChild == null) {
					currentNode.leftChild = node;
					break;
				}
				currentNode = currentNode.leftChild;
			}
		}
		
	}
	/* This is the working solution of Find Method By me*/
	
	/*public Boolean find(Integer item) {
		Node currentNode = root;

		if(item == currentNode.value)
			return true;
		
		while(currentNode != null) {
			if(item > currentNode.value) {
				if(currentNode.rightChild == null){
					return false;
				}
				else if(currentNode.rightChild.value == item) {
					return true;
				}
				else {
					currentNode = currentNode.rightChild;
					continue;
				}
			}
			else {
				if(currentNode.leftChild == null){
					return false;
				}
				else if(currentNode.leftChild.value == item) {
					return true;
				} 
				else {
					currentNode = currentNode.leftChild;
					continue;
				}
			}
		}
		return false;
	}
	*/
	
	
	/*This is the working solution of find Method by Mosh*/
	public Boolean find(Integer item) {
		var currentNode = root;
		while (currentNode != null) {
			if (item > currentNode.value)
				currentNode = currentNode.rightChild;
			else if (item < currentNode.value)
				currentNode = currentNode.leftChild;
			else
				return true;
		}
		return false;
	}
	
	
	
	/*PreOrder Transversing the Tree*/
	/* pre Order => root - left -right */
	public void preOrderTransver() {
		preOrderTransver(root);
	}
	private void preOrderTransver(Node item) {
		if(item == null)
			return;
		System.out.println(item.value);
		preOrderTransver(item.leftChild);
		preOrderTransver(item.rightChild);
	}
	
	
	
	
	/*InOrder traversal => left- root - right */
	/*In Oder treversal will give the value in Asending order.*/
	/*We can make it right - root - left to get data in descending order.*/
	public void inOrderTransver() {
		inOrderTransver(root);
	}
	private void inOrderTransver(Node item) {
		if(item == null)
			return;
		inOrderTransver(item.leftChild);
		System.out.println(item.value);
		inOrderTransver(item.rightChild);
	}
	
	
	/*Post Order traversal => left - right - root*/
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(Node item) {
		if(item == null)
			return;
		postOrderTraversal(item.leftChild);
		postOrderTraversal(item.rightChild);
		System.out.println(item.value);
				
	}
	
	
	
	/*Calculate the Height of the Node*/
	public int height() {
		return height(root);
	}
	
	private int height(Node item) {
		if(item == null)
			throw new IllegalStateException();
		if(item.leftChild == null && item.rightChild == null)
			return 0;
		
		return (1+ Math.max( height(item.leftChild), height(item.rightChild)));
	}
	
	
	/*calculate minimum number in binary tree*/
	public Node minimum () {
		return null;
	}
	
	
	
	
	
	/*Check Equality of 2 Trees*/
	/*This Solution is by me*/
	public Boolean equalsC(Tree tree) {
		return equalsC(tree.root, this.root);
	}
	
	private Boolean equalsC(Node node1, Node node2) {
		if(node1== null && node2==null)
			return true;
		
		Boolean isLeftEqual = equalsC(node1.leftChild, node2.leftChild);
		
		Boolean isRightEqual = equalsC(node1.rightChild, node2.rightChild);
		try {
			return node1.value.equals(node2.value) && isLeftEqual && isRightEqual;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	/* Check the equality By Mosh*/
	public Boolean equals(Tree tree) {
		return equals(root, tree.root);
	}
	
	private Boolean equals(Node first, Node second) {
		if(first == null && second == null)
			return true;
		if(first != null && second != null)
			return first.value == second.value 
					&& equals(first.leftChild,second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		
		return false;
	}
	
	private Boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
	
	
	
	
	/*Validate the Binary Tree. i.e. Is it Binary Search tree*/
	/*Check if Nodes are properly placed.*/
	public Boolean isBST() {
		return this.isBSTC(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
	}
	
	/*Code by Me*/
	private Boolean isBSTC(Node node, Integer min, Integer max) {
		if(isLeaf(node))
			return (node.value > min && node.value < max);
		if(node.value > min 
				&& node.value < max)
			return isBSTC(node.leftChild, min, node.value)
					&& isBSTC(node.rightChild, node.value, max);
		return false;
	}
	
	
	/*By Mosh*/
	private Boolean isBST(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.value < min || root.value >max)
			return false;
		return isBST(root.leftChild, min, root.value - 1)
				&& isBST(root.rightChild, root.value + 1 , max);
	}
	
	/*To mess up binaary Search tree. For Testing of IsBST.*/
	public void swapRoot() {
		var temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}
	
	
	/*Print all the nodes at K'th distance from root*/
	public void printNodeAtKthNode(int dist) {
		printNodeAtKthNode(root, dist);
	}
	
	private void printNodeAtKthNode(Node node, int dist) {
		if(node == null)
			return;
		
		if(dist == 0) {
			System.out.println(node.value);
			return;
		}
		
		printNodeAtKthNode(node.leftChild, dist -1);
		printNodeAtKthNode(node.rightChild, dist - 1);
	}
	
	
	/*Level Order Traversal*/
	public void levelOderTraversal() {
		for(int i = 0; i <= height(); i++) {
			printNodeAtKthNode(i);
		}
	}
	
	
	
	private class Node{
		private Integer value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(Integer value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}

