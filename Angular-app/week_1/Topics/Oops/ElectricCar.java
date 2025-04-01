package Topics.Oops;

public class ElectricCar extends Car{
	private float car_battery_range;
	
	public float getCar_battery_range() {
		return car_battery_range;
	}


	public void setCar_battery_range(float car_battery_range) {
		this.car_battery_range = car_battery_range;
	}
	
	
	public void chargeBattery() {
		System.out.println("The Battery is being charged.");
	}

}
