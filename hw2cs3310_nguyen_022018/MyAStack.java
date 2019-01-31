package hw2cs3310_nguyen_022018;

public class MyAStack {

	public int stack[];
	public static final int defaultSize = 1000;
	public int size;
	public int top;
	
	/**
	 * constructor for stack array
	 * set size to integer parameter, top to 0 and initialize stack array
	 * @param s
	 */
	public MyAStack(int s) {
		size = s;
		top =0;
		stack = new int[s];
		
	}
	
	/**
	 * constructor for stack with default stack size, intializes stack array into default size
	 */
	public MyAStack() {
		size = defaultSize;
		top =0;
		stack = new int[defaultSize];
	}
	
	/**
	 * set top of stack as the passed integer parameter, increment the top
	 * @param n
	 * @return
	 */
	public boolean push(int n) {
		
		if(top>=size) {
			return false;
		}
		
		stack[top] = n;
		top++;
		return true;
		
	}
	
	/**
	 * if top is 0 (array is null) then return null, otherwise, return integer on top of stack
	 * @return
	 */
	public int pop() {
		if(top ==0) {
			return (Integer) null;
			
		}
		int data = stack[top-1];
		//System.out.println("data" +data);
		top--;
		return data;
	}
	
	/**
	 * return top of stack without deleting value
	 * @return
	 */
	public int peep() {
		if(top ==0) {
			return (Integer) null;
		}
		
		return stack[top-1];
	}
	/**
	 * clear stack array
	 */
	public void clear() {
		top = 0;
		
	}
	
	/**
	 * take the passed integer parameter and convert it into a binary string and 
	 * push each bit into to array stack
	 * 
	 * @param n
	 * @return binary string
	 */
	public String store(int n) {
		
		String bin = Integer.toBinaryString(n);
		
		for(int i=0; i< bin.length(); i ++) {
			
			char c = bin.charAt(i);
			String bit = Character.toString(c);
			
			push(Integer.parseInt(bit));
		}
		
		
		
//		for(int a=0; a< bin.length(); a ++) {
//			
//			int b = pop();
//			System.out.print(b);
//			
//			
//		}
		
		return bin;
	}
	
	/**
	 * pop each bit out and turn it into a string and use string builder to reverse it
	 * convert reversed binary number into a decimal
	 * @return
	 */
    public int toDecimal() {
		
		String binary = "";
		int s = top;
		for(int a=0; a< s; a ++) {
		
		int b = pop();
		String bit = Integer.toString(b);
		binary = binary+bit;
		
	}
		
		System.out.println("binary " + binary);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(binary);
		builder = builder.reverse();
		
		String binar = builder.toString();
		
		//System.out.println("reversed string " +binar);
		
		int decimal=Integer.parseInt(binar,2);  
		//System.out.println("decimal " +decimal);
		return decimal;
		
	}
		
}
