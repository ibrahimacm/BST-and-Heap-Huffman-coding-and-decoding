
// important class for huffman coding

public class Node implements Comparable<Node>{
	private Node parent;
	private Node left;
	private Node right;
	private char data;
	private int frequency;
	private int decode;
	
	public Node(char data, int frequency) {
		parent = null;
		left = right = null;
		this.data = data;
		this.frequency = frequency;
		decode = -1;
		
		
		
	}
	public Node(Node left, Node right) {
		parent = null;
		this.left = left;
		// set 0 for left edge
		left.setDecode(0);
		this.right = right;
		// set 1 for right edge
		right.setDecode(1);
		// set space for the parent
		this.data = ' ';
		
		this.frequency = left.getFrequency() + right.getFrequency();
		decode = -1;
		
		
		
	}
	
	// getters for the variables
	public Node getParent() {
		return parent;
	}
	public int getFrequency() {
		return frequency;
	}
	public char getData() {
		return data;
	}
	public int getDecode() {
		return decode;
	}
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	
	// setters for the variables
	public void setDecode(int decode) {
		this.decode = decode;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public void setData(char data) {
		this.data = data;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public void setParent(Node parent) {
		this.parent = parent;;
	}
	
	// check if it's leaf. (if the data not equal to space then it's leaf)
	public boolean isLeaf() {
		return this.data != ' ';
	}
	// When to add node to PriorityQueue compare what a small frequency to order it from small to big.
	public int compareTo(Node p) {
		return  getFrequency() - p.getFrequency() ;
	}
	
	
}
