package AVLTrees;

/*Pending*/
public class AVLTree {
	
	private Node root;

	public static void main(String[] args) {
		/*
		 * 				21
		 * 			  /	   \
		 * 			12		58
		 * 		  /  \        \
		 * 		6	  19       70
		 * 	  /
		 * 	 4
		 *  /
		 *  1
		 * 
		 * */
		var tree = new AVLTree();
		System.out.println("\n21____________");
		tree.insert(21);
		System.out.println("\n58____________");
		tree.insert(58);
		System.out.println("\n22____________");
		tree.insert(22);
//		System.out.println("\n6____________");
//		tree.insert(6);
//		System.out.println("\n19____________");
//		tree.insert(19);
//		System.out.println("\n4____________");
//		tree.insert(4);
//		System.out.println("\n1____________");
//		tree.insert(1);
//		System.out.println("\n70____________");
//		tree.insert(70);
		
	}
	
	/**
	 * // Insert Operation using recursion By me.
	public void insert(Integer item) {
		Node newNode = new Node(item);
		insert(root, newNode);
	}
	
	private void insert(Node root, Node newNode) {
		if (root == null) {
			this.root = newNode;
			return;
		}
		if(newNode.value < root.value && root.leftChild == null) {
			root.leftChild = newNode;
			return;
		}
		else if (newNode.value > root.value && root.rightChild == null) {
			root.rightChild = newNode;
			return;
		}
		else {
			if(newNode.value < root.value) {
				insert(root.leftChild, newNode);
			}
			else if (newNode.value > root.value) {
				insert(root.rightChild, newNode);
			}
			else {
				return;
			}
		}
	}
	*/
	
	
	/*Step1 : Insert Method using Recursion*/
	public void insert(int item) {
		root = insert(root, item);
		root = detectRotation(root);
	}
	
	private Node insert(Node root, int value) {
		if ( root == null)
			return new Node(value);
		if ( value < root.value) {
			root.leftChild = insert(root.leftChild, value);
		}
		else if(value > root.value) {
			root.rightChild = insert(root.rightChild, value);
		}

		/*Step2: Implement feature to store height of each node.(Using Below expression)*/
		setHeight(root);
		
		/*Step 3 : Implement the Balance factor, to check if differnce between 
		 * height of Left and right Childs is <= 1*/
		root.balanceFactor = getHeight(root.leftChild) - getHeight(root.rightChild);
		
		
		return root;
	}
	
	private boolean isLeftHeavy(Node node) {
		return balanceFactor(node) > 1;
	}
	
	private boolean isRightHeavy(Node node) {
		return balanceFactor(node) < -1;
	}
	
	private int balanceFactor(Node node) {
		return (node == null) ? 0 : getHeight(node.leftChild) - getHeight(node.rightChild);
	}
	
	private int getHeight(Node node) {
		if(node == null)
			return -1;
		return node.height;
	}
	
	private Node detectRotation(Node node) {
		
		if (isLeftHeavy(root)) {
			if(root.leftChild.balanceFactor < 0)
				leftRotation(root.leftChild);
//				System.out.println("Left rotation on "+ root.leftChild.value);
//			System.out.println("Right rotation on "+ root.value);
			rightRotation(root);
			
		}
			
		if (isRightHeavy(root)) {
			if(root.rightChild.balanceFactor > 0)
				rightRotation(root.rightChild);
//				System.out.println("Right rotation on "+ root.rightChild.value);
//			System.out.println("Left rotation on "+ root.value);
			leftRotation(root);
		}
		
		return root;
	}
	
	private void leftRotation(Node node) {
		var newRoot = node.rightChild;
		
		root.leftChild = newRoot.rightChild;
		newRoot.leftChild = root;
		
		setHeight(newRoot);
		setHeight(root);
		
		this.root = newRoot;
	}
	
	private void rightRotation(Node node) {
		var newRoot = node.leftChild;
		
		root.rightChild = newRoot.leftChild;
		newRoot.rightChild = root;
		
		setHeight(newRoot);
		setHeight(root);
		
		this.root = newRoot;
	}
	
	private void setHeight(Node root) {
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
	}
	
	private class Node{
		private Integer value;
		private Node leftChild;
		private Node rightChild;
		private int height;
		private int balanceFactor;
		
		public Node(Integer value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
	
}
