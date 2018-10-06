
public class ParkingSpot {
	private VehicleSize size;
	private Vehicle cur_vehicle;
	
	public ParkingSpot(VehicleSize size) {
		this.size = size;
	}
	
	public void print() {
		System.out.print(" "+this.isEmpty()+" & ");
		System.out.print(this.size.name()+"||");
	}
	
	public boolean fit(Vehicle vehicle) {
		return vehicle.getSize() == this.size;
	}
	
	public boolean isEmpty() {
		return this.cur_vehicle == null;
	}
	
	
	public Vehicle getCur_vehicle() {
		return cur_vehicle;
	}

	public boolean park(Vehicle vehicle) {
		if(!isEmpty()) {
			return false;
		} else if(!fit(vehicle)) {
			return false;
		} else {
			this.cur_vehicle = vehicle;
			return true;
		}
	}
	
	public boolean leave(Vehicle vehicle) {
		if(this.isEmpty() || this.cur_vehicle != vehicle) {
			return false;
		} else {
			this.cur_vehicle = null;
			return true;
		}
	}
}
