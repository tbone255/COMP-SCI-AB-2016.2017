import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class AntonsParents 
{
	public static void main(String[] args)
	{
		Scanner s = null;
		TreeSet<String> ts = new TreeSet();
		try {
			s = new Scanner(new File("C:/Users/amirta18/desktop/names.txt"));
			while(s.hasNextLine())
			{
				ts.add(s.nextLine());
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			s.close();
		}
		for(String god: ts)
		{
			System.out.println(god);
		}
 	}
}
