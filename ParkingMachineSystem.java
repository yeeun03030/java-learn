package assignment;

import java.util.Scanner;

public class ParkingMachineSystem {
	static Scanner scan = new Scanner(System.in);
	static Parking [] car = new Parking[8];
	
	static int manual (int state) {
		System.out.println("Parking Land에 오신것을 환영합니다.\n  무엇을 도와드릴까요?\n");
		System.out.println(">>    1. 입고신청  |  2. 출고신청  |  3. 취소\n");
		
		state = scan.nextInt();
		if (state > 2 || state < 0) {
			System.out.println("<error> 다시 입력해주세요.");
			state = 0;
		}
		
		return state;
	}
	
	static int carIn () {
		System.out.print("입고할 차량번호 뒷자리 : "); 
		String num = scan.next(); // 차량번호 입력
		int chk = 999;
		
		for (int i = 0; i < car.length; i++) {
			try {
				if ((car[i] == null && chk != -1) || car[i].inOut == false) { // 빈칸이거나 주차된 것을 뺀 경우
					chk = i;
				}
				if (car[i].carNum == num && car[i].inOut == true) { // 차량번호가 같으면서 주차되어 있을 때
					System.out.println("<error> 해당 차량을 입고할 수 없습니다.\n");
					return 0;
				}
			} catch (Exception e) {
			}
		}
		if (chk == 999) 
			System.out.print("<error> Parking Land에 자리가 없습니다.\n");
		else {
			car[chk] = new Parking(num);
			System.out.println("<success> 입고에 성공했습니다.\n");
		}
			
		return 0;
	}
	
	static int carOut () {
		System.out.print("출고할 차량번호 뒷자리 : ");
		String num = scan.next();
		
		for (int i = 0; i < car.length; i++) {
			try {
				if (car[i].carNum == num && car[i].inOut == true) {
					car[i].inOut = false;
					System.out.println("<success> 출고에 성공했습니다.\n");
					return 0;
				}
			} catch (Exception e) {
			}
		}
		System.out.println("<error> 차량번호 " + num + "는 없습니다.");
		
		return 0;
	}
	
}
