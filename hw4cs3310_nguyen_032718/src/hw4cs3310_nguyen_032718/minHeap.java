package hw4cs3310_nguyen_032718;

import hw4cs3310_nguyen_032718.BST.Node;

/**
 * 
 * @author An
 * 
 * initialize local heap array, maximum size integer and current size integer n
 *
 */
public class minHeap {
	
	private String[] Heap; 
	 private int size;          // Maximum size of the heap
	  private int n;   

	 
/**
 * 
 * @param min
 * 
 * constructor for minHeap, sets min size as passed integer
 */
public minHeap(int min) {
	
	this.size = min;
	Heap = new String[this.size +1];
	n= 0;
	
}

/**
 * 
 * @param pos
 * @return
 * 
 * checks position to see if it's a leaf value and returns true or false
 */
public boolean isLeaf(int pos) {
	
	return (pos >= n/2) && (pos <n); 
		
	
}

/**
 * 
 * @return current size of heap
 */
public int heapSize() {
	return n;
}

/**
 * 
 * @param pos
 * @return
 * 
 * returns parent if it's a child
 */
public int getParent(int pos) {
	if(pos <=0) return -1;
	return (pos-1)/2;
}

/**
 * 
 * @param pos
 * @return
 * 
 * returns left child of position 
 */
public int leftChild(int pos){
	if(pos >= n/2) return -1;
	return 2*pos+1;
}

/**
 * 
 * @param pos
 * @return
 * 
 * returns right child of position
 * 
 */
public int rightChild(int pos){
	if(pos >= n/2) return -1;
	return 2*pos +2;
}

/**
 * 
 * @param pos1
 * @param pos2
 */
public void swap(int pos1, int pos2){
    String temp = Heap[pos1];
    Heap[pos1] = Heap[pos2];
    Heap[pos2] = temp;
}


/**
 * 
 * @param s
 * 
 * insert string into heap array and reheapify
 * if parent is less than current value, then swap
 * 
 */
public void insert(String s) {
	if (n>= size) {
		System.out.println("Heap full");
	}
	
	int curr = n++;
	
	Heap[curr] = s;
	
	while((curr != 0) && (Heap[getParent(curr)].compareTo(Heap[curr]) >0)) {
		
		swap(getParent(curr), curr);
		curr = getParent(curr);
		
		
	}
	
	
}

/**
 * 
 * @param pos
 * 
 * heapify heap array 
 * 
 */
public void minHeapify (int pos) {
	
	if((pos<0) || (pos >= n)) return;
	
	
	while(!isLeaf(pos)) {
		
		int j = leftChild(pos);
		
		if ((j< (n-1) && (Heap[j].compareTo(Heap[j+1]) >0))){
			j++;
		}
		
		if(Heap[pos].compareTo(Heap[j]) <= 0) {
			return;
		}
		
		swap(pos,j);
		pos =j;
	
	}
}


/**
 * 
 * @param h
 * 
 * print out preOrder traversal starting at the top
 */
public void preOrder(int h) {
	
	 if (h >= size) {
	        return;
	    }
	 
	    System.out.print(Heap[h] +", ");
	    preOrder((2 * h)+1);
	    preOrder((2 * h)+2);
	 }
	
/**
 * 
 * @param h
 * 
 * print out inOrder traversal starting at the top
 */
public void inOrder(int h) {
	
	 if (h >= size) {
	        return;
	    }
	 
	    inOrder((2 * h)+1);
	    System.out.print(Heap[h] + ", ");
	    inOrder((2 * h)+2);
	 }
	
/**
 * 
 * @param h
 * 
 * print out post order traversal starting at top
 */
public void postOrder(int h) {
	
	 if (h >= size) {
	        return;
	    }
	 
	    postOrder((2 * h)+1);
	    postOrder((2 * h)+2);
	    System.out.print(Heap[h] + ", ");
	    
	    
	 }
	

	

public void minHeap() {
	
	for (int pos = (size / 2)-1; pos >= 0 ; pos--)
    {
        minHeapify(pos);
    }
}

/**
 * 
 * @return
 * 
 * remove the minimum element in heap
 * swap the minimum with the top of heap and reheapify
 */
public String findMin() {
	
	return Heap[0];
	
	
}

public int size(int index) {		
	
	
	if(leftChild(index) == -1 && rightChild(index) == -1) {
		return 0;
	}
	
	else if(leftChild(index) != -1 && rightChild(index) == -1) {
		return (size(leftChild(index)) +1);
	}
	
	else if(leftChild(index) == -1 && rightChild(index) != -1) {
		return (size(rightChild(index)) +1);
	}
	
	else if(leftChild(index) != -1 && rightChild(index) != -1) {
		return (size(rightChild(index)) + size(leftChild(index))) +1;
	}

	
	
	else return 0;
		
	
	
}
	
	




/**
 * 
 * @param s
 * @return
 * 
 * searches through each element of heap to see if any value matches passed String
 * if true, prints out depth, breadth and parent node 
 * if false, prints out not found
 * 
 * returns true or false if found or not
 * 
 */
public boolean search(String s) {
	
	int num=-1;
	int parent=0;
	int depth;
	int position;
	int count =0;
	
	
	for (int i = 0; i< size ; i++)
    {
        if(Heap[i].compareTo(s) ==0) {
        	num =i;
        	count++;
        }
        
        else 
        	continue;
    }
	
	 if (num==0) {
		
		System.out.println("Found at index " +num);
		System.out.println("Depth: 0");
		System.out.println("Size of subtree: " +size(num));
	}

	 else if(num>size/2) {
		parent = num/2;
		double number = num;
		depth = (int) (Math.log10(number)/ Math.log10(2.0));
		position= (int) (number -Math.pow(2.0, depth));
		System.out.println("Found at index " +num);
		System.out.println("Depth " +depth);
		System.out.println("Leaf Node" );
		System.out.println("Size of subtree: " +size(num));
		
	}
	
	else if(num<size/2 && num!=-1){
		parent = num/2;
	double number = num;
	depth = (int) (Math.log10(number)/ Math.log10(2.0));
	position= (int) (number -Math.pow(2.0, depth));
	
	System.out.println("Found at index " +num);
	System.out.println("Depth " +depth);
	System.out.println("Size of subtree: " +size(num));
	
	
}


	
else 
	System.out.println("Name not found");

	if(count >0){ 
		return true;
	}
	else return false;
	

}

public void print() {
	
	for(int i =0; i < Heap.length; i++) {
		
		System.out.println(Heap[i]);
	}
}


public String findMax() {
	
	String max = Heap[0];
	
	for (int i = size/2; i< size ; i++)
    {
        if(max.compareTo(Heap[i]) <0) {
        	max = Heap[i];
        }
}
	
	return max;
}


}
