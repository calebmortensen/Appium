package coursework;

public class Parent extends Abs implements Grandchild {

	public static void main(String[] args) {
		
		 // Parent p = new Parent(); p.start(); Child c = new Child(); c.start();
		 
		Grandchild gg = new Parent();
		gg.Blue();
		Abs ab = new Parent();
		ab.test();
		

	}
	
	
	public void start() {
		System.out.println("Starting");
	}

	public void stop() {
		System.out.println("Stop");	
	}
	
	public void pause() {
		
		System.out.println("Pause");
	}


	@Override
	public void Green() {
		System.out.println("Printing Grandchild Interface GREEN");
		
	}


	@Override
	public void Red() {
		System.out.println("Printing Grandchild Interface RED");
		
		
	}


	@Override
	public void Blue() {
		System.out.println("Printing Grandchild Interface BLUE");
		
		
	}


	@Override
	public void Purple(String purple) {
		System.out.println(purple);
		
	}


	@Override
	public void test() {
		System.out.println("This is from Grandchild Abstract Class");
		
	}
	
	
}
