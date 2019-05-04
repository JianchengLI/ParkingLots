public class ParkingLot {

    public Ticket park(Car car){
        Ticket ticket = new Ticket(car.getNumber());
        return ticket;
    }
}
