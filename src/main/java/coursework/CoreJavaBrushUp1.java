package coursework;

import java.util.ArrayList;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		
		int myNum = 5;
		String website = "Caleb Mortensen";
		char letter = 'c';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println("My Variables are: " + myNum + " " + website + " " + letter + " " + dec + " " + myCard);

		
		//Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;
		System.out.println(arr[0]);
		System.out.println("SPACE");
		
		int[] arr2 = {7,9,11,22,33,44,55,66,100};
		System.out.println(arr2[0]);
		
		System.out.println("SPACE");
		
		//For Loop
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("SPACE");
		
		
		for (int i = 0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println("SPACE");
		
		String[] name = {"Caleb", "John", "Steve"};
		
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		System.out.println("SPACE");
		//Enhanced For Loop
		for(String s : name ) {
			System.out.println(s);
		}
		
		System.out.println("SPACE AGAIN");
		
		for(int i = 0; i < arr2.length; i++) {
			if (arr2[i] % 2 == 0) {
				System.out.println("EVEN with Modulus " + arr2[i]);
				//break;
			}
			else {
				System.out.println("ODD with Modulus " + arr2[i]);
			}
			
			ArrayList<String> a = new ArrayList<String>();
			a.add("Bob");
			a.add("Peter");
			a.add("Scott");
			a.add("George");
			a.remove(2);
			
			System.out.println(a);
			System.out.println(a.get(2));
			
			//create object of the class - object.method
			System.out.println("SPACE");
			String s2 = new String ("Welcome"); //creates new object in memory space
			String s3 = new String ("Welcome2");
			
			String s = "Caleb A Mortensen THE First"; //string literal
			String[] splitString = s.split(" ");
			System.out.println(splitString[0].trim());
			System.out.println(splitString[1]);
			System.out.println(splitString[2]);
			System.out.println(splitString[3]);
			System.out.println(splitString[4]);
			System.out.println("SPACE");
			
			for (int t = 0; t < s.length(); t++) {
			System.out.println(s.charAt(t));	
			}
			System.out.println("SPACE");
			
			//TO REVERSE (Good Exam question)
			for (int x = s.length()-1; x >= 0; x--) {
				System.out.println(s.charAt(x));	
				}
			
			
		
		}
	}

}
