package hw4cs3310_nguyen_032718;


/**
 * 
 * @author An
 *
 *initialize local root Node and pointer for lastNode inserted
 *initialize integer position to return back position of searched Node
 *initialize integer size to update size of maxHeap
 */
public class maxHeap {

	public Node root;
	public Node lastNode;
	public int position = -1;
	public int size = 0;
	public String[] arr; 
	public int count =0;
	/**
	 * constructor for maxHeap
	 * declares root null and updates size to 0
	 */
	public maxHeap() {
		this.root= null;
		size =0;
		arr = new String[10000];
	}
	
	/**
	 * 
	 * @param s
	 * constructor for insert method
	 * takes in String and calls insert method that heapifies the max Heap
	 */
	public void insert(String s) {
		
		lastNode = insert(s, root);
		arr[count] = s;
		count++;
		
	}
	
	/**
	 * 
	 * @param s - string to be inserted into maxHeap 
	 * @param node- reference node
	 * @return new Node with passed String
	 * 
	 * checks to see if root is null first, if it is then sets creates new Node as the root node and sets position as 0
	 * checks to see if reference Node is a leaf Node, if so then insert to the left and set parent and position
	 * checks to see if reference Node has left child, if so then insert to right and set parent and position
	 * If neither, then traverses through tree, checking the size of left and right subtree to see where to insert
	 * 
	 */
	public Node insert(String s, Node node) {
		
		
		
		if(root == null) {
			Node newNode = new Node(s);
			root = newNode;
			root.setPosition(0);
			size++;
			return newNode;
		}
		
		else if(node.isLeaf()){
			Node newNode = new Node(s);
			node.left = newNode;
			node.left.parent = node;
			node.left.setPosition((node.left.parent.getPosition() *2) +1);
			size++;
			maxHeapify(node.left);
			
			return newNode;
			
		}
		else if(node.getLeft() != null && node.getRight() == null) {
			Node newNode = new Node(s);
			node.right = newNode;
			node.right.parent = node;
			node.right.setPosition((node.right.parent.getPosition() *2) +2);
			size++;
			maxHeapify(node.right);
			
			return newNode;
		}
		else 
			if(size(node.right) == size(node.left)) {
				return insert(s, node.left);
			}
			else if(size(node.left) < size(node.right)) {
				return insert(s, node.left);
			}
			else if(size(node.left) > size(node.right)) {
				return insert(s, node.right);
			}
		

		
	return node;
}
	
	/**
	 * 
	 * @param parent
	 * @param node
	 * 
	 * swaps the data values of two passed Nodes
	 * 
	 */
	public void swap(Node parent, Node node) {
		String temp = parent.getData();
		parent.setData(node.getData()); 
		node.setData(temp);

		
	}
	
	
	/**
	 * 
	 * @param node
	 * 
	 * traverses through maxHeap to heapify heap
	 * checks if parent's value is greater than child, if so then swap
	 */
	public void maxHeapify(Node node) {
		
		while(node.hasParent() && (node.getParent().data.compareTo(node.data) <0)) {
			
			swap(node.parent, node);
			node = node.getParent();
		}
	}
	
	/**
	 * 
	 * @return
	 * 
	 * returns entire size of tree
	 */
	public int size(){
		return size(root);
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 * 
	 * returns the size of subtree in reference to passed Node
	 */
	public int size(Node node) {
		if (node == null) return 0;
		
		else {
			return(size(node.left)+ size(node.right) +1);
		}
	}
	
	/**
	 * 
	 * @param root
	 * 
	 * prints out preOrder traversal
	 */
	public void preOrder(Node root) {
		
		if(root!= null) {
			System.out.print(root.data +", ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * 
	 * @param root
	 * 
	 * prints out inorder traversal
	 */
public void inOrder(Node root) {
		
		if(root!= null) {
			inOrder(root.left);
			System.out.print(root.data+", ");
			inOrder(root.right);
		}
	}
	
/**
 * 
 * @param root
 * 
 * prints out postOrder traversal 
 */
public void postOrder(Node root) {
	
	if(root!= null) {
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+", ");
	}
}
/**
 * 
 * @param root
 * @return 
 * 
 * returns minimum value, compares all of the values
 */
public String getMin(Node root) {
	String min = arr[0];
	for(int i=0; i <size; i++) {
		if(min.compareTo(arr[i]) >0) {
			min = arr[i];
		}
	}
	
	return min;
}

/**
 * returns root which contains max value
 * @return
 */
public String getMax() {
	
	return root.data;
}
	
/**
 * 
 * @param data
 * @return
 * 
 * constructor for search method, checks if root is null first then proceeds to search if not
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
	 * checks to see if node data is equal to passed String data 
	 * if not, then traverses through minHeap to compare data
	 */
	private boolean search(String data, Node node) {
		// TODO Auto-generated method stub
		
		int depth; 
		if(node!= null) {
			
			if(node.getData().compareTo(data) ==0) {
				position = node.getPosition();
				depth = (int) (Math.log10(position)/ Math.log10(2.0));
				
				
				System.out.println("Found.");
				System.out.println("depth: " +depth);
				if(node.isLeaf()) {
					System.out.println("Leaf node");
				}
				
				System.out.println("Subtree size: " +size(node));
				return true;
			}
			else {
				
				return search(data, node.left) || search(data, node.right);
			}
		}
		
		
		return false;
	}

	


	








	/**
	 * 
	 * @author An
	 * 
	 * Node Class for minHeap
	 * contains data field, position, left child, right child and parent
	 *
	 */
class Node {
	String data;
	int position;
	Node left;
	Node right;
	Node parent;
	
	
	/**
	 * constructor for node class
	 */
	public Node() {
		left = right = null;
	}
	
	/**
	 * 
	 * @param data
	 * 
	 * sets passed String as data field, initializes left child, right child and parent
	 * 
	 */
	public Node(String data) {
		
		this.data =data;
		left = null;
		right = null;
		parent =null;
	}
	
	/**
	 * 
	 * @param s
	 * @param l
	 * @param r
	 */

	/**
	 * 
	 * @param s
	 * 
	 * assign data field to passed String
	 */
	public void setData(String s) {
		this.data=s;
	}
	
	/**
	 * 
	 * @return data field
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * 
	 * @param left
	 * 
	 * sets passed Node as left child
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * 
	 * 
	 * @return left child
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * 
	 * @param right
	 * 
	 * set passed Node as right child
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
	/**
	 * 
	 * @return right child
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 * 
	 * @return parent node
	 */
	public Node getParent() {
		return parent;
	}
	
	

	public boolean isLeaf() { 
		return (left == null) && (right ==null);
	
	}
	
	public boolean hasParent() {
		if(parent == null) {
			return false;
		}
		
		else return true;
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
}

}
	

	