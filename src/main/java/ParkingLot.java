import exception.EmptyCarNumberException;

public class ParkingLot {
    private int capacity;

    public ParkingLot() {
        this.capacity = 0;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(car.getNumber().equals("")) { throw new EmptyCarNumberException(); }
        Ticket ticket = new Ticket(car.getNumber());
        return ticket;
    }
}
