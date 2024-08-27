package appiumgroupid.Appium;


public class MethodsDemo extends MethodsDemo2 {

	public static void main(String[] args) {
		
		MethodsDemo d = new MethodsDemo();
		d.getData();
		String name = d.getData1();
		System.out.println(name);
		
		MethodsDemo2 e = new MethodsDemo2();
		String name2 = e.getData2();
		System.out.println(name2);
		
		d.doData(); //object creation
		doData();    // static
	}
	
	public void getData() {
		System.out.println("Hello World");
	}
	//static is used for class level outside of object creation
	public static void doData() {
		System.out.println("DoData Stuff");
	}
	
}
