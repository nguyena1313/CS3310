package hw2cs3310_nguyen_022018;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
	MyLLStack s = new MyLLStack();
	MyLLQueue q = new MyLLQueue();
	MyAStack sa = new MyAStack();
	MyAQueue qa = new MyAQueue();
	double startTime, startTime1, startTime2, startTime3;
	double endTime, endTime1, endTime2, endTime3;
	double totalTime, totalTime1, totalTime2, totalTime3;
	double tTimeSum =0;
	double tTimeSum1 =0;
	double tTimeSum2 =0;
	double tTimeSum3 =0;
	Random rand = new Random();
	int n =5;
	

	for(int i =0; i <n; i++) {
    int num = rand.nextInt(1000);
    System.out.println();
	System.out.println("LL stack");
	startTime= System.nanoTime();
	String bin = s.store(num);
	int dec = s.toDecimal();
	endTime = System.nanoTime();
	totalTime= endTime-startTime;
	System.out.println("Decimal: " +dec);
	System.out.println("Binary: " +bin);
	System.out.println("Time: " +totalTime+ " nanoseconds");
	tTimeSum =tTimeSum + totalTime;
	System.out.println();
	
	


	
	System.out.println();
	System.out.println("array stack");
	startTime1= System.nanoTime();
	String bin1 = sa.store(num);
	int dec1 = sa.toDecimal();
	endTime1 = System.nanoTime();
	totalTime1= endTime1-startTime1;
	System.out.println("Decimal: " +dec1);
	System.out.println("Binary: " +bin1);
	System.out.println("Time: " +totalTime1+ " nanoseconds");
	tTimeSum1 =tTimeSum1 + totalTime1;
	System.out.println();
	
	
	
	
	
	System.out.println();
	System.out.println("queue");
	startTime2= System.nanoTime();
	String bin2 = q.store(num);
	int dec2 = q.toDecimal();
	endTime2 = System.nanoTime();
	totalTime2= endTime2-startTime2;
	System.out.println("Decimal: " +dec2);
	System.out.println("Binary: " +bin2);
	System.out.println("Time: " +totalTime2+ " nanoseconds");
	tTimeSum2 =tTimeSum2 + totalTime2;
	System.out.println();

	
	System.out.println();
	System.out.println("array queue");
	startTime3= System.nanoTime();
	String bin3 = qa.store(num);
	int dec3 = qa.toDecimal();
	endTime3 = System.nanoTime();
	totalTime3= endTime3-startTime3;
	System.out.println("Decimal: " +dec3);
	System.out.println("Binary: " +bin3);
	System.out.println("Time: " +totalTime3+ " nanoseconds");
	tTimeSum3 =tTimeSum3 + totalTime3;
	System.out.println();
	}
	
	
	System.out.println();
	System.out.println("average Time for LL stack " +tTimeSum/n);
	System.out.println("average Time for array stack " +tTimeSum1/n);
	System.out.println("average Time for LL queue " +tTimeSum2/n);
	System.out.println("average Time for array queue " +tTimeSum3/n);
	
	PrintStream out = new PrintStream(new FileOutputStream("hhw2cs3310_nguyen.txt"));
	System.setOut(out);
	

}
}