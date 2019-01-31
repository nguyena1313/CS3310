package hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//An Nguyen
//CS 3310
// To compare linear and binary search
// I give permission to the instructor to share my solution(s) with the class.
/**
 * 
 * @author An
 *
 */
public class hw1 {
	
	public static void main(String[] args) {
		/**
		 * initialize variables
		 * 
		 */
		// variables
		int rows;
		int columns;
		char [][] letters ;
		String name;
		final String alphabet;
		final int length;
		int[] rowIndex;
		int[] columnIndex;
		char [] names;
		boolean [] check;
		char letters2[];
		int counter;
		int size;
		double startTime, endTime;
		
		/**
		 * set name and initialize array length
		 */
		name = "john";
		names = new char[name.length()];
		check = new boolean[name.length()];
		rowIndex = new int[name.length()];
		columnIndex = new int[name.length()];
		
		
		
		/**
		 * Put each character of name into array 
		 * set row and column index to -1
		 */
		for (int n=0; n <name.length(); n++){
			names[n] = name.charAt(n);
			check[n] = false;
			rowIndex[n]= -1;
			columnIndex[n]= -1;
		
		}
		
		/**
		 * Get user input for nxn matrix
		 * calculate size of array 
		 * set rows and columns for letters array
		 * 
		 */
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter in an integer.");
		rows = columns = keyboard.nextInt();
		
		size = rows*columns;
		
	
		letters = new char[rows][columns];
		
		
		/**
		 * generate random letters into nxn array
		 */
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		length = alphabet.length()-1;
		
		Random rand = new Random();
		
		for (int i = 0; i< rows; i++) {
		for ( int j = 0; j < columns; j++) {
			letters[i][j] = (alphabet.charAt(rand.nextInt(length)));
		
		
		
		}
		
		}
		
		/**
		 * initialize 1d array
		 * print nxn array
		 */
		letters2 = new char[columns*rows];
		
		
		System.out.println(Arrays.deepToString(letters));
		System.out.println();
		
			
		/**
		 * run linear search
		 * measure time of search
		 * 
		 */
		startTime = System.nanoTime();
		//System.out.println(startTime);
		for(int i=0; i <1; i++){
			for (int a = 0; a <rows; a++) {
				   for (int b= 0; b< columns; b++) {
					   for (int c =0; c< name.length(); c++){
						   if(names[c]== letters[a][b]) {
							   rowIndex[c]= a;
							   columnIndex[c] =b;
							   check[c] = true;
							   break;	   
						   }				   
					   }		 
				   }				   
			   }
		}
			endTime= System.nanoTime();
			System.out.println("Search time: " +(endTime-startTime)/1000000);
		
			for (int k=0; k<names.length; k++){
				
				System.out.println(names[k]+ ": ");
				System.out.println("Index: [" +rowIndex[k]+ ", " +columnIndex[k]+ "]\n");

			}
	
	counter =0;

	/**
	 * put 2d array into 1d array and sort and put back
	 */
	for (int i = 0; i< rows; i++) {
		for ( int j = 0; j < columns; j++) {
			
			
			letters2[counter++] = letters[i][j];
			
		
		
		}
	}
	
	Arrays.sort(letters2);
	
	
	counter =0;
	for (int a = 0; a< rows; a++) {
		for (int d = 0; d<columns; d++){
			letters[a][d] = letters2[counter++];
		}
	}
	
	System.out.println();
	System.out.println(Arrays.deepToString(letters));
	System.out.println();
	
	/**
	 * Call binary search 
	 */

	for (int i=0; i< name.length(); i ++) {
	if (binarySearch(letters, name.charAt(i)) == true){
		System.out.println();
		
	}
	else 
		System.out.println(name.charAt(i)+ ": \nIndex: [-1,-1] \n ");
              }
	}
	
	
	/**
	 * 
	 * @param matrix
	 * @param c
	 * @return
	 * 
	 * binarySearch method
	 * 
	 */
	public static boolean binarySearch(char[][] matrix, char c) {
		/**
		 * initialize variables
		 */
		int row = matrix.length;
		int columns = matrix[0].length;
		
		int start =0;
		int end = row*columns-1;
		
		/**
		 * run binary search
		 * 
		 */
		double startTime = System.nanoTime();
		for(int k=0; k <1; k++){
		while(start <= end){
			int mid = (start+end)/2;
			int midX =mid/columns;
			int midY = mid%columns;
			
			if(matrix[midX][midY]== c){ 
				
				System.out.println(c+":");
				System.out.println("Index: [" +midX+ ", " +midY+ "]" );
				double endTime= System.nanoTime();
				System.out.println("Search time =  "+(endTime-startTime)/1000000);
				
				return true;
				
				
			}
			if (matrix[midX][midY] < c){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
			
				
			
		}
		
		
		
		}
		

		return false;
	}
	}

	       
       
