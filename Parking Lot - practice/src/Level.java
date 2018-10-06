
public class Level {
	private final ParkingSpot[] spots;
	
	public Level(int n) {
		spots = new ParkingSpot[n];
		for(int i=0; i<n/2; i++) {
			spots[i] = new ParkingSpot(VehicleSize.Car);
		}
		for(int i=n/2; i<n; i++) {
			spots[i] = new ParkingSpot(VehicleSize.Truck);
		}
	}
	
	public void print() {
		for(ParkingSpot spot : spots) {
			spot.print();
		}
	}
	// if has spot, return index; else, return -1
	public int hasSpot(Vehicle vehicle) {
		for(int i=0; i<spots.length; i++) {
			if(spots[i].isEmpty() && spots[i].fit(vehicle)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean park(Vehicle vehicle) {
		int index = hasSpot(vehicle);
		if(index == -1) {
			return false;
		} else {
			spots[index].park(vehicle);
			return true;
		}
	}
	
	public boolean leave(Vehicle vehicle) {
		for(ParkingSpot spot : spots) {
			if(spot.getCur_vehicle() == vehicle) {
				spot.leave(vehicle);
				return true;
			}
		}
		return false;
	}
}
