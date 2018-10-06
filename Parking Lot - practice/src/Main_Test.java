import java.util.ArrayList;
import java.util.List;

public class Main_Test {
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot(3, 10);
//		System.out.println("constructed a new empty parking lot:");
//		lot.print();
		System.out.println("print every spot's status : isEmpty()? & VehicleSize ");
		System.out.println("begin to park vehicles: ");
		List<Vehicle> list = new ArrayList<>();
		for(int i=0; i<15; i++) {
			final Vehicle v = (i % 2 == 0 ? new Car() : new Truck());
			list.add(v);
			lot.park(v);
		}
		lot.print();
		System.out.println("some vehicles leaved");
		for(int i=0; i<8; i++) {
			lot.leave(list.get(i));
		}
		lot.print();
	}
}
