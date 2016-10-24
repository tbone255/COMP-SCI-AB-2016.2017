
public class Tester {

	public static void main(String[] args) {
		
		LinkedList<Integer> a = new LinkedList < Integer>();
		
		a.add(5);
		a.add(6);
		a.add(7);
	
		Object[] arr =  a.toArray();
		
		
		System.out.println(a.toString());
		
	}

}
