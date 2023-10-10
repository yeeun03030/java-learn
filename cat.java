package assignment;

public class cat extends animal {
	boolean on;
	
	public cat(String name) {
		super(name);
		on = true;
	}
	
	public static void meow () {
		System.out.println("야옹 ~");
	}
}
