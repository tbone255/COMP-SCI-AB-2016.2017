import java.io.File;
import java.util.Scanner;

public class Reader
{
	
	public static void main(String[] args)
	{
		Scanner s;
		s = null;
		
		try {
			s = new Scanner(System.in);
			System.out.print("Type a directory for a file you bamboozled buffoon:");
			String file = s.next();
			Scanner readFile = null;
			try {
				readFile = new Scanner( new File(file) );
			}
			catch ( Exception e) {
				System.out.println("Do you even file");
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Do you even file");
		}
		finally {
			
		}
	}
	
}
