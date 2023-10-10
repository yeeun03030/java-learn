package assignment;

import java.util.Scanner;

public class Hotel {
	static Scanner scan = new Scanner(System.in);
	static animal [] am = new animal[2];
	
	static int Menu() {
		System.out.printf("   [ 메뉴 ]\n 1. 입실\n 2. 퇴실\n 3. 현황\n   + 입·퇴실 동물 수: %d\n", animal.chknum);
		System.out.print(">> ");
		int state = scan.nextInt();
		if (state <= 0 || state > 3) {
			System.out.println("<error> 입력 값 오류\n<system> 다시 입력해주세요.\n");
			return 0;
		}
		System.out.println();
		return state;
	}
	// 입력받은 숫자가 1보다 작거나 4보다 클 경우 (메뉴 이외의 숫자를 입력할 경우) 다시 입력 에러를 출력하고 return 0 해줌
	// if문이 실행되지 않는다면 return state를 바로 실행함
	
	static int ChkIn() {
		String n;
		int chk = 999;

		cat c;
		dog d;
		
		System.out.println("   [ 입실 ]\n * 입실할 동물의 종류를 골라주세요.\n\n 1. cat\n 2. dog\n 3. 메뉴로 돌아가기");
		System.out.print(">> ");
		int k = scan.nextInt();
		
		if (k <= 0 || k > 3) {
			System.out.println("<error> 입력 값\n<system> 다시 입력해주세요.\n");
			return 1;
		}
		else if (k == 3) {
			System.out.println("<system> 메뉴로 돌아갑니다.\n");
			return 0;
		}
		else {
			System.out.print(">> 동물의 이름을 입력해주세요: ");
			n = scan.next();
			for (int i = 0; i < am.length; i++) {
				try {
					if (am[i] == null) { // am[i]이 비어있을 경우, 야옹이
						chk = i;

						break;
					}
					else if (am[i].name.equals(n)) { // 이름이 동일한 입실원이 있을 경우
						System.out.println("<error> 이름이 동일한 입실원이 존재\n<system> 메뉴로 돌아갑니다.\n");
						return 0;
					}
					else if (am[i].chk == false && chk == 999) { // 퇴실을 통해 공간이 빈 경우, chk가 999일 경우 해당 칸의 index를 저장
						chk = i;
					}
				} catch (Exception e) {
				}
			}
			
			if (chk == 999) {
				System.out.println("<error> 만실로 인한 입실 불가\n<system> 메뉴로 돌아갑니다.\n");
				return 0;
			} else {
				if (k == 1) {
					c = new cat(n);
					am[chk] = (animal)c;
				} else {
					d = new dog(n);
					am[chk] = (animal)d;
				}
				System.out.printf("<success> %s이(가) 입실에 성공하였습니다!\n<system> 메뉴로 돌아갑니다.\n\n", n); 
			}
		}
		return 0;
	}
	// 입실 메뉴가 뜸과 동시에 숫자를 입력받음
	// 입력받은 숫자가 1보다 작거나 3보다 클 경우 (메뉴 이외의 숫자를 입력할 경우) 다시 입력 에러를 출력하고 return 1 해줌
	// 입력받은 숫자가 3과 같을 경우 메뉴로 돌아가는 안내문구와 함께 return 0 해줌
	// 호텔 객체의 갯수만큼 도는 동안
	// - animal[i].chk == false and animal[i].name.equles("입력한 이름")
	// - 
	
	static int ChkOut() {
		return 0;
	}
	
	static int List() {
		System.out.println("   [ 현재 호텔 입실 현황 ]\n");
		for (int i = 0; i < am.length; i++) {
			if (am[i] == null || am[i].chk == false) {
				System.out.printf("10%d호: 비어있음\n", i+1);
				continue;
			}
			System.out.printf("10%d호: %s이(가) 사용중\n", i+1, am[i].name);
		}
		System.out.println();
		return 0;
	}

	static int Fin() {
		return 100;
	}
}
