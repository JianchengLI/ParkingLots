import exception.EmptyCarNumberException;
import exception.ParkingLotsFullException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Ticket, Car> lots = new HashMap<>();

    public ParkingLot() {
        this.capacity = 0;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if (!isAvailable()) { throw new ParkingLotsFullException(); }
        if(car.getNumber().equals("")) { throw new EmptyCarNumberException(); }

        Ticket ticket = new Ticket(car.getNumber());
        lots.put(ticket, car);
        return ticket;
    }

    public boolean isAvailable() {
        return lots.size() < capacity;
    }
}
