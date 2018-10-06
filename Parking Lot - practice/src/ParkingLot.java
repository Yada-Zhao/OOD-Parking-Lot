
public class ParkingLot {
	private final Level[] levels;
	
	public ParkingLot(int n_levels, int n_spots) {
		levels = new Level[n_levels];
		for(int i=0; i<n_levels; i++) {
			levels[i] = new Level(n_spots);
		}
	}
	
	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println();
		}
		System.out.println("");
	}
	// return which level has spot
	public int hasSpot(Vehicle vehicle) {
		for(int i=0; i<levels.length; i++) {
			int that_level_spotIndex = levels[i].hasSpot(vehicle); 
			if(that_level_spotIndex != -1) {
				return i;
			}
		}
		return -1;
	}
	public boolean park(Vehicle vehicle) {
		int index_level = hasSpot(vehicle);
		if(index_level == -1) {
			return false;
		} else {
			levels[index_level].park(vehicle);
			return true;
		}
	}
	public boolean leave(Vehicle vehicle) {
		for(Level level : levels) {
			if(level.leave(vehicle)) {
				return true;
			}
		}
		return false;
	}	
}
