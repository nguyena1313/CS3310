package hw4cs3310_nguyen_032718;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class main {

	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * read from files and put them into arrays
	 * instantiate minHeap, maxHeap and BST objects
	 * insert each name from first array into each data structure
	 * 
	 * run the functions of each object and record time 
	 * 
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
	
		
		File f = new File("starwars.txt");
		File f1 = new File("starwars_tiny.txt");
		Scanner sc = new Scanner(f);
		Scanner sc1 = new Scanner(f1);
		String[] nameFiles = new String[116];
		String[] nameFiles1 = new String[5];
		String [] firstArray = new String[114];
		String[] secondArray = new String[4];
		
		double[] startTime = new double[20];
		double[] endTime = new double[20];
		double[] totalTime = new double[20];
		
		
		String s;
		int count = 0;
		int count1 =0;
		

	    while(sc.hasNextLine())
	    {
	    	
	    	s = sc.nextLine();
	    	s= s.trim();
	    	s=s.replaceAll("\\s+", " ");
	    	String[] name = s.split(" ");
	    	
	    	nameFiles[count] = s;
	    	//System.out.println(nameFiles[count]);
	    	count++;
	    }
	    
	    while(sc1.hasNextLine())
	    {
	    	
	    	s = sc1.nextLine();
	    	s= s.trim();
	    	s=s.replaceAll("\\s+", " ");
	    	String[] name = s.split(" ");
	    	
	    	nameFiles1[count1] = s;
	    	count1++;
	    }
	    
	    for(int i =0; i < firstArray.length; i++) {
	    	firstArray[i] = nameFiles[i];
	    }
	    
	    for(int i = 0; i < secondArray.length; i++) {
	    	secondArray[i] = nameFiles1[i];
	    }
	    
	    double start =0;
		double end =0;
	    
		
			// REGULAR TEST
			
//		
//	    minHeap min = new minHeap(firstArray.length);
//	    
//	    System.out.println("Min heap: ");
//	    for(int i=0; i <firstArray.length; i++) {
//	   
//	   startTime[0] = System.nanoTime();
//	   min.insert(firstArray[i]);
//	   endTime[0] = System.nanoTime();
//	   totalTime[0] += (endTime[0]-startTime[0]);
//
//	}
//	    startTime[1] = System.nanoTime();
//	    String minValue = min.findMin();
//	    endTime[1] = System.nanoTime();
//	    
//	    startTime[2] = System.nanoTime();
//	    String maxValue = min.findMax();
//	    endTime[2] = System.nanoTime();
//	    System.out.println("Average insert time: " +(totalTime[0]/ firstArray.length)+ " nanoseconds");
//	    System.out.println("Preorder traversal: ");
//	    min.preOrder(0);
//	    System.out.println();
//	    System.out.println("Min: " +minValue+ "         Max: " +maxValue);
//	    
//	    for(int i =0; i <secondArray.length; i++) {
//	    System.out.println();
//	    System.out.println("Searching for ' " +secondArray[i] + " ' ");
//	    startTime[3] = System.nanoTime();
//	    min.search(secondArray[i]);
//	    endTime[3] = System.nanoTime();
//	    System.out.println("Time to find: " +(endTime[3] - startTime[3]) +" nanoseconds");
//	    totalTime[3] += (endTime[3]-startTime[3]);
//	    
//	    }
//	    
//	    System.out.println();
//	    System.out.println("Max value search time: " +(endTime[2] - startTime[2]) + " nanoseconds");
//	    System.out.println("Min value search time: " +(endTime[1] - startTime[1]) + " nanoseconds");
//	    System.out.println("Average search time: " +(totalTime[3] / secondArray.length) + " nanoseconds");
//	    
//	    
//	    
//	    System.out.println("\n-----------------------------------------------------");
//	    System.out.println("Max heap: ");
//	    System.out.println("-----------------------------------------------------");
//	    maxHeap max = new maxHeap();
//	  for(int i=0; i <firstArray.length; i++) {
//	   startTime[4] = System.nanoTime();
//	   max.insert(firstArray[i]);
//	   endTime[4] = System.nanoTime();
//	   totalTime[4] += (endTime[4] - startTime[4]);
//	}
//	  
//	  startTime[6] = System.nanoTime();
//	  String m = max.getMin(max.root);
//	  endTime[6] = System.nanoTime();
//	  
//	  startTime[7] = System.nanoTime();
//	  String ma = max.getMax();
//	  endTime[7] = System.nanoTime();
//	  
//	  System.out.println("Average insert time: " +(totalTime[4]/ firstArray.length));
//	  System.out.println("Post Order traversal: ");
//	  max.postOrder(max.root);
//	  
//	  System.out.println("Min: " +m+ "         Max: " +ma);
//	  
//	  for(int i =0; i <secondArray.length; i++) {
//	  System.out.println();
//	  System.out.println("Searching for: " +secondArray[i]);
//	  startTime[5] = System.nanoTime();
//	  boolean result = max.search(secondArray[i]);
//	  endTime[5] = System.nanoTime();
//		if(result == false) {
//			  System.out.println("Not found");
//		  }
//	  System.out.println("Time to find: " +(endTime[5] - startTime[5]) +" nanoseconds");
//	  totalTime[5] += (endTime[5] - startTime[5]);
//	  }
//
//	  
//	  System.out.println();
//
//	    System.out.println();
//	    System.out.println("Max value search time: " +(endTime[7] - startTime[7]) + " nanoseconds");
//	    System.out.println("Min value search time: " +(endTime[6] - startTime[6]) + " nanoseconds");
//	    System.out.println("Average search time: " +(totalTime[5] / secondArray.length) + " nanoseconds");
//	  
//	  
//
//   BST b = new BST();
//		   
//		   
//		   for(int i=0; i <firstArray.length; i++) {
//		    	startTime[8] = System.nanoTime();
//			   b.insert(firstArray[i]);
//			   endTime[8] = System.nanoTime();
//			   totalTime[8] += (endTime[8] - startTime[8]);
//			  
//			}
//		   
//
//		
//		   System.out.println("\n---------------------------------");
//			System.out.println("Binary Search Tree");
//			System.out.println("---------------------------------");
//
//			System.out.println("Average insert time: " +(totalTime[8]/ firstArray.length)+ " nanoseconds");
//			
//		    System.out.println("In Order Traversal : ");
//		    b.inOrder(b.root);
//		    
//		    System.out.println();
//		    startTime[9] = System.nanoTime();
//			b.min(b.root);
//		    endTime[9] = System.nanoTime();
//		    
//		    startTime[10] = System.nanoTime();
//		    b.max(b.root);
//		    endTime[10] = System.nanoTime();
//		    
//		    System.out.println();
//		    
//		   
//		  
//			  for(int i =0; i <secondArray.length; i++) {
//				  System.out.println();
//				  System.out.println("Searching for: " +secondArray[i]);
//				  startTime[11] = System.nanoTime();
//				  boolean result = b.search(secondArray[i]);
//				  endTime[11] = System.nanoTime();
//				  System.out.println("Time to find: " +(endTime[11] - startTime[11]) +" nanoseconds");
//				  totalTime[11] += (endTime[11] - startTime[11]);
//				  }
//			
//			    System.out.println();
//			    System.out.println("Max value search time: " +(endTime[10] - startTime[10]) + " nanoseconds");
//			    System.out.println("Min value search time: " +(endTime[9] - startTime[9]) + " nanoseconds");
//			    System.out.println("Average search time: " +(totalTime[11] / secondArray.length) + " nanoseconds");
//			  
			    
			    
			    
			    
			    
			    System.out.println();
			    
			    
			    

// Testing N

				
			    //------------------
				int n= 500;
				//------------------
				
				
				
				System.out.println("n: " +n);
			    System.out.println();
				String[] test = new String[n];

				
				Random r = new Random();
				for(int d =0; d<n; d++) {
				int k=	r.nextInt(firstArray.length);
				test[d] = firstArray[k];
				}
		
				
			    minHeap min = new minHeap(test.length);
			    
			    System.out.println("Min heap: ");
			    for(int i=0; i <test.length; i++) {
			   
			   startTime[0] = System.nanoTime();
			   min.insert(test[i]);
			   endTime[0] = System.nanoTime();
			   totalTime[0] += (endTime[0]-startTime[0]);

			}
			    startTime[1] = System.nanoTime();
			    String minValue = min.findMin();
			    endTime[1] = System.nanoTime();
			    
			    startTime[2] = System.nanoTime();
			    String maxValue = min.findMax();
			    endTime[2] = System.nanoTime();
			    System.out.println("Average insert time: " +(totalTime[0]/ test.length)+ " nanoseconds");
			    System.out.println("Preorder traversal: ");
			    min.preOrder(0);
			    System.out.println();
			    System.out.println("Min: " +minValue+ "         Max: " +maxValue);
			    
			    for(int i =0; i <secondArray.length; i++) {
			    System.out.println();
			    System.out.println("Searching for ' " +secondArray[i] + " ' ");
			    startTime[3] = System.nanoTime();
			    min.search(secondArray[i]);
			    endTime[3] = System.nanoTime();
			    System.out.println("Time to find: " +(endTime[3] - startTime[3]) +" nanoseconds");
			    totalTime[3] += (endTime[3]-startTime[3]);
			    
			    }
			    
			    System.out.println();
			    System.out.println("Max value search time: " +(endTime[2] - startTime[2]) + " nanoseconds");
			    System.out.println("Min value search time: " +(endTime[1] - startTime[1]) + " nanoseconds");
			    System.out.println("Average search time: " +(totalTime[3] / secondArray.length) + " nanoseconds");
			    
			    
			    
			    System.out.println("\n-----------------------------------------------------");
			    System.out.println("Max heap: ");
			    System.out.println("-----------------------------------------------------");
			    maxHeap max = new maxHeap();
			  for(int i=0; i <test.length; i++) {
			   startTime[4] = System.nanoTime();
			   max.insert(test[i]);
			   endTime[4] = System.nanoTime();
			   totalTime[4] += (endTime[4] - startTime[4]);
			}
			  
			  startTime[6] = System.nanoTime();
			  String m = max.getMin(max.root);
			  endTime[6] = System.nanoTime();
			  
			  startTime[7] = System.nanoTime();
			  String ma = max.getMax();
			  endTime[7] = System.nanoTime();
			  
			  System.out.println("Average insert time: " +(totalTime[4]/ test.length));
			  System.out.println("Post Order traversal: ");
			  max.postOrder(max.root);
			  
			  System.out.println("Min: " +m+ "         Max: " +ma);
			  
			  for(int i =0; i <secondArray.length; i++) {
			  System.out.println();
			  System.out.println("Searching for: " +secondArray[i]);
			  startTime[5] = System.nanoTime();
			  boolean result = max.search(secondArray[i]);
			  endTime[5] = System.nanoTime();
			  if(result == false) {
				  System.out.println("Not found");
			  }
			  System.out.println("Time to find: " +(endTime[5] - startTime[5]) +" nanoseconds");
			  totalTime[5] += (endTime[5] - startTime[5]);
			  }

			  
			  System.out.println();

			    System.out.println();
			    System.out.println("Max value search time: " +(endTime[7] - startTime[7]) + " nanoseconds");
			    System.out.println("Min value search time: " +(endTime[6] - startTime[6]) + " nanoseconds");
			    System.out.println("Average search time: " +(totalTime[5] / secondArray.length) + " nanoseconds");
			  
			  

		   BST b = new BST();
				   
				   
				   for(int i=0; i <test.length; i++) {
				    	startTime[8] = System.nanoTime();
					   b.insert(test[i]);
					   endTime[8] = System.nanoTime();
					   totalTime[8] += (endTime[8] - startTime[8]);
					  
					}
				   

				
				   System.out.println("\n---------------------------------");
					System.out.println("Binary Search Tree");
					System.out.println("---------------------------------");

					System.out.println("Average insert time: " +(totalTime[8]/ test.length)+ " nanoseconds");
					
				    System.out.println("In Order Traversal : ");
				    b.inOrder(b.root);
				    
				    System.out.println();
				    startTime[9] = System.nanoTime();
					b.min(b.root);
				    endTime[9] = System.nanoTime();
				    
				    startTime[10] = System.nanoTime();
				    b.max(b.root);
				    endTime[10] = System.nanoTime();
				    
				    System.out.println();
				    
				   
				  
					  for(int i =0; i <secondArray.length; i++) {
						  System.out.println();
						  System.out.println("Searching for: " +secondArray[i]);
						  startTime[11] = System.nanoTime();
						  boolean result = b.search(secondArray[i]);
						  endTime[11] = System.nanoTime();
						  System.out.println("Time to find: " +(endTime[11] - startTime[11]) +" nanoseconds");
						  totalTime[11] += (endTime[11] - startTime[11]);
						  }
					
					    System.out.println();
					    System.out.println("Max value search time: " +(endTime[10] - startTime[10]) + " nanoseconds");
					    System.out.println("Min value search time: " +(endTime[9] - startTime[9]) + " nanoseconds");
					    System.out.println("Average search time: " +(totalTime[11] / secondArray.length) + " nanoseconds");
					  
					    
					    
					    
					    
					    
					    System.out.println();
					    
						PrintStream out = new PrintStream(new FileOutputStream("hw3cs3310_nguyen.txt"));
						System.setOut(out);
					    
		
	}

	
	
}
