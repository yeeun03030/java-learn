package assignment;

public class animal {
	// 방은 2개
	// 호텔에서 나갈 때 멍멍 or 야옹 하고 나감
	// 고양이, 강아지 구분
	String name;
	boolean chk;
	static int chknum;
	
	public animal (String name) {
		this.name = name;
		
		chk = true;
		chknum += 1;
	}
}
