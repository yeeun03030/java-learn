package assignment;
import java.util.Scanner;

public class Parking {
	static Scanner scan = new Scanner(System.in);
	static User[] customer = new User[8];
	
	public static int Menu() { // 메뉴 출력
		System.out.println(" [ 메뉴 ]");
		System.out.println("  1. 입고");
		System.out.println("  2. 출고");
		System.out.println("  3. 주차 목록\n");
		
		System.out.print(">> ");
		int state = scan.nextInt();
		if (state > 3 || state < 1) {
			System.out.println("<error> 다시 입력해주세요. \n");
			return 0;
		}
		return state;
	}
	
	public static int CarIn() {
		System.out.print("<system> 입고할 차량번호 4자리를 입력해주세요. : ");
	    String number = scan.next();
	    int key = 10;
	    
	    for (int i = 0; i < customer.length; i++) {
	    	if (customer[i] == null) {
	    		customer[i] = new User(number);
	    		
	    		System.out.printf("<success> 입고에 성공하였습니다. (차량번호: %s)\n", number);
	    		System.out.println("<system> 메뉴로 돌아갑니다.\n");
	    		return 0;
	    	}
	    	if (number.equals(customer[i].carNum) && customer[i].check == true) { // 같은 번호의 차가 주차되어 있는 경우
	    		System.out.println("<error> 입고에 실패하였습니다. (사유: 같은 번호의 차량이 주차 되어있음)");
	    		System.out.println("<system> 메뉴로 돌아갑니다.\n");
	    		return 0;
	    	}
	    	else if (customer[i].check == false && key == 10) {
	    		key = i;
	    	}
	    	if (customer[i] != null && i >= 7) {
	    		if (key != 10) {
		    		customer[i] = new User(number);
		    		
		    		System.out.printf("<success> 입고에 성공하였습니다. (차량번호: %s)\n", number);
		    		System.out.println("<system> 메뉴로 돌아갑니다.\n");
		    		return 0;
	    		}
	    		System.out.println("<error> 입고에 실패하였습니다. (사유: 주차 자리가 부족함)");
	    		System.out.println("<system> 메뉴로 돌아갑니다.\n");
	    		return 0;
	    	}
	    }
		
		
		return 0;
	}
	
	public static int CarOut() {
		System.out.print("<system> 출고할 차량번호 4자리를 입력해주세요. : ");
		String number = scan.next();
		
		for (int i = 0; i < customer.length; i++) {
			if (customer[i] == null) {
				System.out.println("<error> 출고에 실패하였습니다. (사유: 해당 번호의 차량은 입고되지 않았음)");
				System.out.println("<system> 메뉴로 돌아갑니다.\n");
				return 0;
			}
			if (number.equals(customer[i].carNum) && customer[i].check == true) {
				customer[i].check = false;
				System.out.printf("<succenss> 출고에 성공하였습니다. (차량번호: %s)\n", number);
				System.out.println("<system> 메뉴로 돌아갑니다.\n");
				return 0;
			}
			else if (number.equals(customer[i].carNum) == false && i >= 7) {
				System.out.println("<error> 출고에 실패하였습니다. (사유: 해당 번호의 차량은 입고되지 않았음)");
				System.out.println("<system> 메뉴로 돌아갑니다. \n");
				return 0;
			}
		}
		return 0;
	}
	
	public static int List() {
		System.out.println(" [ 목록 ]");
		for (int i = 0; i < customer.length; i++) {
			if (customer[i] == null || (customer[i].check == false)) {
				System.out.printf("  %d번자리 : 비어있음\n", i+1);
			}
			else if (customer[i] != null) {
				System.out.printf("  %d번자리 : %s\n", i+1, customer[i].carNum);
			}
		}
		System.out.println();
		return 0;
	}
}
