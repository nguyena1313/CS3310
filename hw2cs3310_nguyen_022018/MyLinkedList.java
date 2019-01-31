package hw2cs3310_nguyen_022018;

public class MyLinkedList {
	private MyNode head;
	private MyNode tail;
	private MyNode curr;
	private int listSize;
	
	
	/**
	 * initialize local variables
	 * 
	 */
	public MyLinkedList() {
	tail = new MyNode(null);
	head = new MyNode(tail);
	curr = tail;
	listSize= -1;
	
}
	/**
	 * 
	 * @param c
	 * @return 
	 * 
	 * insert method which takes in character and sets it as current Object
	 * and changes position of old current character
	 * increments list size
	 * 
	 */
	public boolean insert (int n) {
		curr.setNext(new MyNode(curr.element(), curr.next()));
		curr.setElement(n);
		//System.out.println("current element" +curr.element());
		if (curr == tail) {
			tail = curr.next();		
		}
		
		listSize++;
		
		return true;
		
		
	}
	
	/**
	 * checks if list is empty first
	 * sets current to next node
	 * sets next pointer of current two nodes ahead
	 * decrement list size
	 * @return deleted node
	 */
	public int delete() {
		if (curr == tail) {
			return (Integer) null; 
		}
		int temp = curr.element();
		//System.out.println("delete current " +temp);
		curr.setElement(curr.next().element());
		
		if (curr.next() == tail) {
			tail = curr;
		}
		
		curr.setNext(curr.next().next());
		listSize --;
		
		return temp;
		
		
	}
	
	/**
	 * add Node with parameter c at tail of array
	 * increment list size
	 * @param c
	 * @return
	 */
	public boolean append(int c) {
		
		tail.setNext(new MyNode(null));
		tail.setElement(c);
		tail = tail.next();
		listSize++;
		return true;
	}
	
	/**
	 * set pointer to head
	 */
	public void moveToHead() {
		curr = head.next;
	}

	/**
	 * checks if position is within range of linkedlist
	 * move to current position of passed position integer
	 * 
	 * @param pos
	 * @return true
	 */
	public boolean moveToPos(int pos) {
	    if ((pos < 0) || (pos > listSize)) return false;
	    curr = head.next();
	    for(int i=0; i<pos; i++) curr = curr.next();
	    return true;
	  }
	
	/**
	 * return char at current pointer node
	 * @return
	 */
	public int getValue() {
		
		int n = curr.element();
		return n;
		
		}
		
	/**
	 * return list size
	 * @return listSize
	 */
	public int size(){
		return listSize;
	}
}
	
