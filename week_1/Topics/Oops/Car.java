package Topics.Oops;
import java.time.Year;
public class Car {
	private String car_make;
	private String car_model;
	private Year  car_year ;
	
	public String getCar_make() {
		return car_make;
	}
	public void setCar_make(String car_make) {
		this.car_make = car_make;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public Year getCar_year() {
		return car_year;
	}
	public void setCar_year(Year car_year) {
		this.car_year = car_year;
	}
	
	public void startEngine() {
		System.out.println("The Engine has Started.");
	}
	
	@Override
	public String toString() {
		return "Car [car_make=" + car_make + ", car_model=" + car_model + ", car_year=" + car_year + "]";
	}

}
