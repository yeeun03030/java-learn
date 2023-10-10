package assignment;

public class MainStage {
	public static void main(String[] args) {
		int stage = 0;
		
		while(true) {
			switch(stage) {
			case 0:
				stage = Hotel.Menu();
				break;
			case 1:
				stage = Hotel.ChkIn();
				break;
			case 2:
				stage = Hotel.ChkOut();
				break;
			case 3:
				stage = Hotel.List();
				break;
			case 4:
				stage = Hotel.Fin();
				break;
			}
			
			if (stage == 100) 
				break;
		}
	}
}
