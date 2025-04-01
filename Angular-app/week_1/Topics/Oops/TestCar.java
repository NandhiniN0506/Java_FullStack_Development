package Topics.Oops;

public class TestCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car[] carObjects = new Car[6];
		for (int i = 0; i < 6;i++) {
			if (i <= 2) {
				//Object for Car Class
				Car car = new Car();
				carObjects[i] = car;
			}
			else {
				//Object for Electric Class
				ElectricCar electric  = new ElectricCar(); 
				carObjects[i] = electric;
			}	
		}

		for (int i = 0;i < carObjects.length;i++) {
			System.out.printf("Printing startEngine() method from the  %s",carObjects[i].getClass());
			System.out.println();
			carObjects[i].startEngine();
		}
	}

}
