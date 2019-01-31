package hw2cs3310_nguyen_022018;

public class MyAQueue {

	public int queue[];
	public static final int defaultSize = 1000;
	public int size;
	public int front;
	public int rear;
	int count = 0;
	
	
	public MyAQueue(int s) {
		size = s;
		rear =0; 
		front =1;
		
		queue = new int[s];

	}
	
	public MyAQueue() {
		size = defaultSize;
		rear =0; 
		front =1;
		
		queue = new int[defaultSize];
	}
	
	public boolean enqueue(int n) {
		
		if(((rear+2)%size) == front) {
			return false;
		}
		
		rear = (rear+1) %size;
		queue[rear] = n;
		
		count++;
		return true;
	}
	
	public int dequeue() {
		if(length() == 0) {
			return (Integer) null;
		}
		
		int data = queue[front];
		front = (front+1) % size;
		count--;
		return data;
	}
	
	public int peek() {
		if(length() ==0) {
			return (Integer) null;
		}
		
		return queue[front];
	}
	
	
	public int length() {
		return count;
	}
	
	/**
	 * take the passed integer parameter and convert it into a binary string and 
	 * enqueue each bit into to linked list queue 
	 * 
	 * @param n
	 * @return
	 */
	public String store(int n) {
		
		String bin = Integer.toBinaryString(n);
		
		for(int i=0; i< bin.length(); i ++) {
			
			char c = bin.charAt(i);
			String bit = Character.toString(c);
			
			
			enqueue(Integer.parseInt(bit));
			
		}
		

		
		return bin;
	}
	

	/**
	 * dequeue each bit out and turn it into a string and use string builder to reverse it
	 * convert reversed binary number into a decimal
	 * @return decimal equivalent
	 */
	public int toDecimal() {
		
		String binary = "";
		int c = count;
		for(int a=0; a< c; a ++) {
		
		int b = dequeue();
		String bit = Integer.toString(b);
		binary = binary+bit;
		
	}
		
		System.out.println("binary " + binary);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(binary);

		
		String binar = builder.toString();

		
		int decimal=Integer.parseInt(binar,2);  

		return decimal;
		
		
	}
	
	
	
	
	
	
	
}
