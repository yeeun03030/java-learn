package assignment;



public class ParkingCustomer {
	public static void main(String[] args) {
		// 차량 번호를 입력하여 입고나 출고할 수 있음
		// 중복된 차량번호 입력시 입고할 수 없음
		// 출고시 없는 차량번호 입력시 출고 할 수 없음
		// 최대 8대 주차 가능
		int state = 0;
		while (true) {
			switch (state) {
			case 0:
				state = ParkingMachineSystem.manual(state);
			case 1:
				state = ParkingMachineSystem.carIn();
			case 2:
				state = ParkingMachineSystem.carOut();
			}
		}
	}
}