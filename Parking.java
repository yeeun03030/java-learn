package assignment;

public class Parking {
	String carNum;
	boolean inOut;
	
	public Parking (String carNum) {
		this.carNum = carNum;
		inOut = true;
		
		System.out.printf("%d, %d\n ", carNum, inOut);
	}
	
}
