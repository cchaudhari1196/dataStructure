package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("chirag");
		trie.insert("chintu");
		trie.insert("card");
		trie.insert("care");
		trie.insert("careful");
		trie.insert("car");
		trie.insert("egg");
//		System.out.println(trie.contains("chirag"));
		
//		trie.treverse();
		
//		trie.remove("chintu");
//		System.out.println(trie.contains("chirag"));
//		System.out.println(trie.contains("chintu"));
		
		
		System.out.println(trie.autoComplete("c").toString());
	}

}

class Trie {
	
	private Node root = new Node( (char) 0 );
	
	/*Trie Implementation by me with Array as a backing data type. 
	 * (Moshs code is also simlar but without the modularization)*/
	/*
	private class Node {
		private char value;
		private boolean isEndOfWorld = false;
		private Node[] children = new Node[26];
		
		public Node(char value) {
			this.value = value;
		}
	}
	
	
	public void insert(String item) {
		
		var node = root;
		for(char ch: item.toCharArray()) {
			if(!isCharPresent(ch, node.children))
				node = insertNode(ch, node);
			else
				node = node.children[indexOfChar(ch)];
		}
		node.isEndOfWorld = true;
	}
	
	private boolean isCharPresent(char ch, Node[] list) {
		var index = indexOfChar(ch);
		return (list[index] == null) ? false : true;
	}
	
	private int indexOfChar(char ch) {
		return ch - 'a';
	}
	
	private Node insertNode (char ch, Node parent) {
		var node = new Node(ch);
		parent.children[indexOfChar(ch)] = node;
		return node;
	}
	*/
	
	
	
	
	
	
	
	
	/*Insert Method by Mosh using Hashmap.*/
	private class Node {
		private char value;
		private boolean isEndOfWorld = false;
		private HashMap<Character, Node> children = new HashMap<>();
		
		public Node(char value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		
		private boolean hasChild(char ch) {
			return children.containsKey(ch);
		}
		
		private void addChild(char ch) {
			children.put(ch, new Node(ch));
		}
		
		private Node getChild(char ch) {
			return children.get(ch);
		}
		
		private boolean isLastChar() {
			return isEndOfWorld;
		}
		
		private Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}
		
		private void removeChild(char ch) {
			children.remove(ch);
		}
		
	}
	
	public void insert(String word) {
		var node = root;
		for (char ch: word.toCharArray()) {
			if (!node.hasChild(ch))
				node.addChild(ch);
			node = node.getChild(ch);
		}
		node.isEndOfWorld = true;
	}
	
	public boolean contains(String word) {
		if (word == null)
			throw new IllegalArgumentException();
		var node = root;
		for (char ch : word.toCharArray()) {
			if (!node.hasChild(ch))
				return false;
			node = node.getChild(ch);
		}
		return node.isLastChar();
	}
	
	
	/**
	 *  Traverse has 2 types
	 *  1. Pre Order - Top(root) to botton(leaf) - adding sysout before for loop
	 *  2. Post Order - Bottom(leaf) to top(root) - adding sysout after for loop
	 */
	public void treverse() {
		treverse(root);
	}
	
	private void treverse(Node node) {
		for(Node child: node.getChildren())
			treverse(child);

		System.out.println(node.value);
	}
	
	
	public void remove(String word) {
		remove(root,0, word);
	}
	
	private void remove(Node node,int at,String word) {
		if(word.length() == at) {
			node.isEndOfWorld = false;
			return;
		}
		if(node == null)
			return;
		
		var child = node.getChild(word.charAt(at));
		
		remove(node.getChild(word.charAt(at)), at+1, word);
		
		if(child.children.isEmpty() && !child.isEndOfWorld)
			node.removeChild(word.charAt(at));
			
	}
	
	
	
	/*AutoCompletion...which returns all the word which matches prefix*/
	public List<String> autoComplete(String prefix) {
		var child = getLastNodeOf(prefix);
		List<String> wordList = new ArrayList<>();
		autoComplete(child, prefix, wordList);
		return wordList;
	}
	
	/**
	 * @param node - node for recursive call
	 * @param prefix - we will create all possible combination of words using prefix
	 * @param wordList - possible combination of word we'll store in this list
	 * 
	 * @rootCondition - here we have not used root condition bcz, 
	 * 					root condition is - 'return if no children of node param.'
	 * 					Now, In for loop we are getting the children.
	 * 						if no childern, then it will eventually return void (without iterating)
	 */
	private void autoComplete(Node node, String prefix, List<String> wordList) {
		if(node == null)
			return;
		if(node.isEndOfWorld) {
			wordList.add(prefix);
		}
		
		for(Node child : node.getChildren()) {
			autoComplete(child, prefix + child.value, wordList);
		}
		
	}
	
	private Node getLastNodeOf(String prefix) {
		if(prefix == null)
			return null;
		
		var child = root;
		for(Character ch : prefix.toCharArray()) {
			child = child.getChild(ch);
			if(child == null)
				return null;	
		}
		return child;
	}
}