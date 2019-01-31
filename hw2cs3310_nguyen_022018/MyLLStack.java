package hw2cs3310_nguyen_022018;

public class MyLLStack {


	MyLinkedList list = new MyLinkedList();
	int count = 0; 
	
	/**
	 * move pointer to head and insert passed int
	 * @param data
	 */
	public void push(int data){
		
		list.moveToHead();
		list.insert(data);
		count ++;
	}

	/**
	 * 
	 * @return head node
	 * 
	 *move to head and delete Node at head
	 */
	public int pop() {
		list.moveToHead();
		count--;
		return list.delete();
		
			
		}
	
	/**
	 * 
	 * @return
	 * 
	 * checks to see if list is empty and returns true or false
	 */
	public boolean isEmpty() {
        if (list.size() ==-1) {
        	return true;
    }
        else return false;
		
	}
	
	/**
	 * moves pointer to head and returns value
	 * @return head node
	 */
	public int peek() {
		list.moveToHead();
		
		return list.getValue();
		
		
	}
	
	/**
	 * return size of list
	 * @return
	 */
	public int size() {
		int s = list.size();
		return s;
	}
	
	/**
	 * take the passed integer parameter and convert it into a binary string and 
	 * push each bit into to linked list stack 
	 * 
	 * @param n
	 * @return binary string
	 */
	public String store(int n) {
		
		String bin = Integer.toBinaryString(n);
		//System.out.println(bin);
		
		for(int i=0; i< bin.length(); i ++) {
			
			char c = bin.charAt(i);
			String bit = Character.toString(c);

			
			push(Integer.parseInt(bit));
		}
		
//		for(int a=0; a< bin.length(); a ++) {
//			
//			int b = pop();
//			System.out.print(b);
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
		int c = count;
		
		for(int a=0; a< c; a ++) {
		
		int b = pop();
		String bit = Integer.toString(b);
		binary = binary+bit;
		
	}
		
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(binary);
		builder = builder.reverse();
		
		String binar = builder.toString();
		
		
		int decimal=Integer.parseInt(binar,2);  
		return decimal;
	}
	
	
	
}
		
		

		


