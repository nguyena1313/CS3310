package hw2cs3310_nguyen_022018;

public class MyLLQueue {

MyLinkedList list = new MyLinkedList();
int count =0;
	/**
	 * append data passed through into list
	 * @param data
	 */
	public void enqueue (int data) {
	list.append(data);
	count++;	
	}
	
	/**
	 * set pointer to head and remove head
	 * @return
	 */
	public int dequeue (){
		list.moveToHead();
		count--;
		return list.delete();
	}
	
	/**
	 * checks if list is empty and returns true or false
	 * @return
	 */
	public boolean isEmpty() {
        if (list.size() ==-1) {
        	return true;
    }
        else return false;
		
	}
	
	
	/**
	 * move pointer to head and returns value at head
	 * @return
	 */
	public int peek() {
		list.moveToHead();
		return list.getValue();
	}
	
	/**
	 * 
	 * return listsize
	 */
	public int size() {
		return list.size();
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
		System.out.println(bin);
		
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
		//builder = builder.reverse();
		
		String binar = builder.toString();
		
		
		int decimal=Integer.parseInt(binar,2);  

		return decimal;
	}
	
	
}

