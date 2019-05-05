import exception.EmptyCarNumberException;
import exception.ParkingLotsFullException;
import exception.TicketInvalidException;
import exception.TicketNullException;

import java.util.List;


public class GraduateParkingBoy {

    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        if (car.getNumber().equals("")){ throw new EmptyCarNumberException(); }

        ParkingLot parkingLot = findFirstAvailableParkingLot(parkingLots);
        if(parkingLot == null){ throw new ParkingLotsFullException(); }
        return parkingLot.park(car);
    }

    public Car pick(Ticket ticket, List<ParkingLot> parkingLots) {
        if(ticket == null){ throw new TicketNullException(); }
        ParkingLot parkingLot = findTicketOwnerParkingLots(ticket, parkingLots);
        if(parkingLot == null){ throw new TicketInvalidException(); }
        return parkingLot.pick(ticket);
    }

    private ParkingLot findTicketOwnerParkingLots(Ticket ticket, List<ParkingLot> parkingLots){
        for (ParkingLot parkingLot : parkingLots){
            if(parkingLot.hasTicket(ticket)){
                return parkingLot;
            }
        }
        return null;
    }

    private ParkingLot findFirstAvailableParkingLot(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots){
            if(parkingLot.isAvailable()){
                return parkingLot;
            }
        }
        return null;
    }
}

