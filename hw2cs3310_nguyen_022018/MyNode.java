package hw2cs3310_nguyen_022018;

public class MyNode {
	/**
	 * initialize local integer and next MyNode
	 */
	int myNum;
	public MyNode next;
	
	/**
	 * constructor that passes an int and MyNode object and sets them to local variables
	 * @param myNum 
	 * @param next
	 */
	public MyNode(int myNum, MyNode next){
		this.myNum = myNum;
		this.next = next;
	}
	
	/**
	 * sets MyNode object to local object next
	 * @param next
	 */
	public MyNode(MyNode next){
		//this.myData = (Character) null;
		this.next = next;
	}
	
	/**
	 * set next to passed object n
	 * @param n
	 */
	public void setNext(MyNode n) {
		next = n;
		
	}
	
	/**
	 * set local myNum integer to passed integer c
	 * @param c
	 */
	public void setElement(int c){
		this.myNum = c;
		//System.out.println("myNum" + myNum);
	}
	
	/**
	 * 
	 * @return MyNum object next
	 */
	public MyNode next() {
		return next;
	}
	
	/**
	 * 
	 * @return local integer
	 */
	public int element() {
		return myNum;
	}
}

