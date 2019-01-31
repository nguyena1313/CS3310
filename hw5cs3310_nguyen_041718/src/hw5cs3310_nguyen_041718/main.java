package hw5cs3310_nguyen_041718;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class main {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 * Read file and put it in HDTest Data Objects
	 * Put HDTestData objects in different AVL Trees in implementation and Testing portions
	 * 
	 * Printed out breadth first and depth first AVLTree in Implementation
	 * 
	 * Inserted, Searched, and then Deleted in Testing. Printed out average times for each 
	 */
	public static void main(String[] args) throws IOException {
	
		System.out.println();
	    System.out.println("------------------------------------------------------------------------");
	    System.out.println("Part A: Implementation");
	    System.out.println("------------------------------------------------------------------------");
	    
		
		File f = new File("data_tiny.csv");
		f.createNewFile();
		String s;
		Scanner sc = new Scanner(f);
		
		
		String tiny[] = new String[16];
		String main[] = new String[73654];
		String entryArray[];
		String entryArray1[];
		String[] temp = new String[16];
		String[] temp1 = new String[16];
		String[] temp2 = new String[16];
		String[] temp3 = new String[16];
		String[] mtemp = new String[73654];
		String[] mtemp1 = new String[73654];
		String[] mtemp2 = new String[73654];
		String[] mtemp3 = new String[73654];
		String[] number = new String[15];
		String[] model = new String[15];
		String[] capacity = new String[15];
		String[] hours = new String[15];
		String[] mnumber = new String[73653];
		String[] mmodel = new String[73653];
		String[] mcapacity = new String[73653];
		String[] mhours = new String[73653];
		HDTestData[] HD = new HDTestData[15];
		HDTestData[] HD1 = new HDTestData[73653];
		
		
		double[] startTime = new double[20];
		double[] endTime = new double[20];
		double[] totalTime = new double[20];
		int count =0;
		int count1 =0;
		
		
			while(sc.hasNextLine()) {
			
			s = sc.nextLine() +",";
			s = s.trim();
			//String[] names = s.split(",");
			tiny[count] = s;
			count++;
		}
			
			String result = String.join("", tiny);
			entryArray = result.split(",");
			

		    for(int i=0; i <(entryArray.length/4); i++) {
			    
				temp[i] = entryArray[4*i].trim();
				temp1[i] = entryArray[4*i+1].trim();
				temp2[i] = entryArray[4*i+2].trim();
				temp3[i] = entryArray[4*i+3].trim();
				
		}
		    
		    for(int i=0; i <number.length; i++) {    
		 		number[i] = temp[i+1];
		 		model[i] = temp1[i+1];
		 		capacity[i] = temp2[i+1];
		 		hours[i] = temp3[i+1];
		 		
		 }
		    
		    
		    
		    for(int i=0; i <HD.length; i++) {    
		    	HDTestData test = new HDTestData(number[i], model[i],
		    	capacity[i], hours[i]);
		    	HD[i] = test;
		 		
		 }
		    
		    AVLTree<String> tree = new AVLTree<>();  
		    AVLTree<String> tree1 = new AVLTree<>();
		    AVLTree<String> tree2 = new AVLTree<>();
		    AVLTree<String> tree3 = new AVLTree<>();
		    
		    
		    for(int i=0; i < number.length; i++) {
		    tree.insert(HD[i].HDNumber);
		    tree1.insert(HD[i].HDModel);
		    tree2.insert(HD[i].HDCapacity);
		    tree3.insert(HD[i].HDHours);
		    }
		    
		   
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Serial Number" );
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Breadth First:" );
		    tree.LevelOrder();
		    System.out.println("\n\nDepth First:" );
		    tree.printDepth(tree.root);
		    System.out.println();
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Model" );
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Breadth First:" );
		    tree1.LevelOrder();
		    System.out.println("\n\nDepth First:" );
		    tree1.printDepth(tree.root);
		    System.out.println();
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Capacity" );
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Breadth First:" );
		    tree2.LevelOrder();
		    System.out.println("\n\nDepth First:" );
		    tree2.printDepth(tree.root);
		    System.out.println();
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Hours" );
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Breadth First:" );
		    tree3.LevelOrder();
		    System.out.println("\n\nDepth First:" );
		    tree3.printDepth(tree.root);
		    
		    
		    
		    
		    
		    //TESTING 

		    System.out.println();
		    System.out.println("\n---------------------------------------------------------------------");
		    System.out.println("Part B: Testing");
		    System.out.println("------------------------------------------------------------------------");
		    

		    
			File f1 = new File("data_main.csv");
			f1.createNewFile();
			Scanner sc1 = new Scanner(f1);
			
			
			while(sc1.hasNextLine()) {
				
			s = sc1.nextLine() +",";
			s = s.trim();
			main[count1] = s;
			count1++;
		}
			
			String result1 = String.join("", main);
			//System.out.println(result1);
			entryArray1 = result1.split(",");
			
		    for(int i=0; i <(entryArray1.length/4); i++) {
			    
				mtemp[i] = entryArray1[4*i].trim();
				mtemp1[i] = entryArray1[4*i+1].trim();
				mtemp2[i] = entryArray1[4*i+2].trim();
				mtemp3[i] = entryArray1[4*i+3].trim();
				
		}
		    
		    for(int i=0; i <HD1.length; i++) {    
		    	HDTestData test = new HDTestData(mtemp[i+1], mtemp1[i+1],
		    	mtemp2[i+1], mtemp3[i+1]);
		    	HD1[i] = test;
		 }
		    
		    AVLTree<String> ntree = new AVLTree<>();  
		    AVLTree<String> ntree1 = new AVLTree<>(); 
		    AVLTree<String> ntree2 = new AVLTree<>(); 
		    AVLTree<String> ntree3 = new AVLTree<>(); 
		    
		    
		    // n and m
		    int n = 1000;
		    int m =5; 
		    Random r = new Random(1);
		    Random r1 = new Random(1);
		    
		    System.out.println("n = " +n+ " m = " +m );
		    
		    HDTestData[] HDObj = new HDTestData[n];

			
			
		    for(int i=0; i < n; i++) {
		    	
		    	int index = r.nextInt(HD1.length);
		    	HDObj[i] = HD1[index];
		    	startTime[0] = System.nanoTime();
			    ntree.insert(HD1[index].HDNumber);
			    ntree1.insert(HD1[index].HDModel);
			    ntree2.insert(HD1[index].HDCapacity);
			    ntree3.insert(HD1[index].HDHours);
			    endTime[0] = System.nanoTime();
			    totalTime[0] += (endTime[0] - startTime[0]);
			   
			}
		    
		    System.out.println("\n--------------------------------------------------------");
		    System.out.println("Inserting " );
		    System.out.println("--------------------------------------------------------");
		    System.out.print("Average insert time: " +(totalTime[0] / n*4) +" ns");
		    
		    
		    String search, search1, search2, search3;
		    
		    
		    
		    System.out.println("\n\n--------------------------------------------------------");
		    System.out.println("Searching " );
		    System.out.println("--------------------------------------------------------");
		    for(int i =0; i <m; i++) {
		    int index = r1.nextInt(HD1.length);
		    search = HD1[index].HDNumber;
		    search1 = HD1[index].HDModel;
		    search2 = HD1[index].HDCapacity;
		    search3 = HD1[index].HDHours;
		    
		    System.out.println("\nSearching for: " +search);
		    
		    startTime[1] = System.nanoTime();
		    boolean found = ntree.search(search);
		    boolean found1 = ntree1.search(search1);
		    boolean found2 = ntree.search(search2);
		    boolean found3 = ntree1.search(search3);
		    endTime[1] = System.nanoTime();
		    totalTime[1] += (endTime[1] - startTime[1]);
		    
		    if(found) {
		    System.out.println("Serial Number: " +HD1[index].HDNumber+ " Model: " +HD1[index].HDModel+ " Capacity: " +HD1[index].HDCapacity+ " Hours:  " +HD1[index].HDHours);
		    }
		    
		    
		    
		    }
		    
		    System.out.println("\nAverage search time: " +(totalTime[1]/m) +" ns");
		    
		    
		    System.out.println("\n\n--------------------------------------------------------");
		    System.out.println("Deleting " );
		    System.out.println("--------------------------------------------------------");
		    for(int i=0; i < n; i++) {
		    	
		    	startTime[2] = System.nanoTime();
		    	ntree.remove(HDObj[i].HDNumber);
		    	endTime[2] = System.nanoTime();
		    	
		    	totalTime[2] += (endTime[2] - startTime[2]);
		    	//System.out.println(totalTime[2]);
			}
		    
		    System.out.println("Average delete time: " +totalTime[2]/n);
	}

}
