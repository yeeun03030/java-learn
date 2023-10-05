package assignment;

public class ParkingSystem {
// 차량번호를 입력하여 입고나 출고할 수 있음
// 중복된 차량번호 입력시 입고할 수 없음
// 출고시 없는 차량번호 입력시 출고할 수 없음
// 최대 8대 주차 가능
	public static void main(String[] args) {
		int state = 0;
		
		while(true) {
			switch (state) {
			case 0:
				state = Parking.Menu();
				break;
			case 1:
				state = Parking.CarIn();
				break;
			case 2:
				state = Parking.CarOut();
				break;
			case 3:
				state = Parking.List();
				break;
			}
		}
	}
}
