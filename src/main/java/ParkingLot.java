import exception.*;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Ticket, Car> lots = new HashMap<>();
    private Map<String, Car> dictionary = new HashMap<>();

    public ParkingLot() {
        this.capacity = 0;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(!isAvailable()) { throw new ParkingLotsFullException(); }
        if(hasCarNumber(car.getNumber())) { throw new DuplicateCarNumberException(); }
        if(car.getNumber().equals("")) { throw new EmptyCarNumberException(); }

        Ticket ticket = new Ticket(car.getNumber());
        lots.put(ticket, car);
        dictionary.put(car.getNumber(), car);
        return ticket;
    }

    public Car pick(Ticket ticket) {
        if(ticket == null) { throw new TicketNullException(); }
        if(!hasTicket(ticket)){ throw new TicketInvalidException(); }
        return lots.get(ticket);
    }

    public boolean isAvailable() {
        return lots.size() < capacity;
    }

    public boolean hasTicket(Ticket ticket){return lots.get(ticket) != null;}
    public boolean hasCarNumber(String number){return dictionary.get(number) != null;}

}
