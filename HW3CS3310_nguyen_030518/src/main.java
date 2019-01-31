import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("data_main.csv");
		f.createNewFile();
		String s;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			
			
			//stack
			s = sc.nextLine();
			System.out.println(s);
			
		}
	}

}
