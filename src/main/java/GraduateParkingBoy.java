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

    private ParkingLot findFirstAvailableParkingLot(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots){
            if(parkingLot.isAvailable()){
                return parkingLot;
            }
        }
        return null;
    }
}

