package hw4cs3310_nguyen_032718;

import hw4cs3310_nguyen_032718.maxHeap.Node;

/**
 * 
 * @author An
 * 
 * binary search tree class
 * initialize root Node and size integer
 *
 */
public class BST {

	public Node root;
	private int size = 0;
	private int pos =0; 
	
	
	/**
	 * constructor for BST class
	 * sets root to null and size to 0
	 */
	public BST() {
		this.root= null;
		size =0;
	}
	
	/**
	 * 
	 * @param s
	 * constructor for insert method, 
	 * calls root as reference node and passes string through another insert method
	 */
	public void insert(String s) {
		
		root = insert(s, root);
		
	}
	
	/**
	 * 
	 * @param s
	 * @param node
	 * @return
	 * 
	 * creates new Node with passed String
	 * if root is null then set new Node as root
	 * 
	 * checks string and compares it to left and right subtrees to see where it should be inserted
	 * alphabetized from left to right
	 * 
	 */
	public Node insert( String s, Node node) {
		
		Node newNode = new Node(s);
		
		
		if(root == null) {
			
			root = newNode;
			root.setPosition(0);
			size++;
			return newNode;
		}
		
		if(node != null) {
			if(s == null){
				node.right = insert(s, node.right);
				
			}
			
			else{
				if(node.data() == null){
					node = new Node(s);
					node.right = insert(null, node.right);
				}
				if(s.compareTo(node.data) < 0){
					node.left = insert(s, node.left);
				}
				if(s.compareTo(node.data) > 0){
					node.right = insert(s, node.right);		
				}
			}			
		} 
		else {
			
			
			node = new Node(s);
			size++;
		}
		
	return node;
}
	

	
	/**
	 * 
	 * @param data
	 * @return
	 * 
	 * constructor for search method
	 * if root is null then return false
	 * takes passed String data and calls search method with data and root as reference node
	 */
	public boolean search(String data) {
		if(root == null){
			return false;
		}else{
			return search(data, root);
		}
	}

	/**
	 * 
	 * @param data
	 * @param node
	 * @return
	 * 
	 * checks passed String data and if it's less than root node, then call recursively to the left
	 * if it's more than root node, then call recursively to the right
	 */
	private boolean search(String data, Node node) {
		// TODO Auto-generated method stub
		if(data != null) {
			
			if(data.compareTo(node.data()) == 0) {
				System.out.println("Found");
				if(node.isLeaf()) {
					System.out.println("Leaf node");
				}
				System.out.println("Subtree size: " +size(node));
				
				return true;
			}
			else{
				if(data.compareTo(node.data()) < 0){
					if(node.left == null){
						System.out.println("Not found");
						return false;
					}
					else{
						return search(data, node.left);
					}
				}
				else if(data.compareTo(node.data()) > 0){
					if(node.right == null){
						System.out.println("Not found");
						return false;
					}
					else{
						return search(data, node.right);
					}
				}
			}	
		}
		
		
		return false;		
	}
	
	/**
	 * 
	 * @return size of tree
	 */
	public int size(){
		return size(root);
	}
	
	/**
	 * 
	 * @param node
	 * @return size of subtree
	 */
	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		
		else {
			return(size(node.left)+ size(node.right) +1);
		}
	}

	/**
	 * 
	 * @param node
	 * 
	 * print out post order traversal in reference to head node
	 */
	 void postOrder(Node node) {
	        if (node == null){
	        	 return;
	        }  
	       postOrder(node.left);
	       postOrder(node.right);
	       System.out.print(node.data + " ");
	    }



	 /**
	  * 
	  * @param node
	  * 
	  * print out rpreorder traversal in reference to head node
	  */
	 void preOrder(Node node)
	    {
	        if (node == null){
	            return;
	        }

	        System.out.print(node.data+ " ");
	        preOrder(node.left);
	        preOrder(node.right);
	    }

	 
	 /**
	  * 
	  * @param node
	  * 
	  * print out in order traversal in reference to head node
	  */
	 void inOrder(Node node)
	    {
	        if (node == null)
	            return;
	        
	        inOrder(node.left);
	        System.out.print(node.data+ " ");
	        inOrder(node.right);
	    }




	 void min(Node node)
	    {
	        if (node == null){
	            return;
	        }
	        min(node.left);
	        if(node.left == null) {
		        System.out.print("Min: " +node.data+ " ");
		        }
	    }


	 void max(Node node)
	    {
	        if (node == null){
	            return;
	        }
	        max(node.right);
	        if(node.right == null) {
	        System.out.print("Max: "+ node.data+ " ");
	        }
	    }



	 /**
	  * 
	  * @author An
	  *
	  *node class for BST
	  *instantiate data field and left and right child
	  */
class Node {
	String data;
	int position;
	Node left;
	Node right;
	Node parent;
	
	
	/**
	 * 
	 * @param data
	 * 
	 * constructor for node class
	 * takes in passed string and sets it to data field
	 * sets left and right child as null
	 */
	public Node (String data) {
		
		this.data =data;
		parent = null;
		left = null;
		right = null;
	}
	
	/**
	 * 
	 * @return data field
	 */
	public String data() {
		return data;
	}
	
	/**
	 * 
	 * @param left
	 * sets passed node as left child
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * 
	 * @return left child
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * 
	 * @param right
	 * sets passed node as right child
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
	/**
	 * 
	 * @return
	 * return right child
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 * 
	 * @param n
	 * set position according to minHeap
	 */
	public void setPosition(int n) {
		this.position = n;
	}
	
	/**
	 * 
	 * @return position
	 */
	public int getPosition() {
		return position;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean hasParent() {
		if(parent == null) {
			return false;
		}
		
		else return true;
	}
	
	public void setParent(Node n) {
		this.parent = n;
	}
	
	public boolean isLeaf() { 
		return (left == null) && (right ==null);
	
	}
}

	
	
}
