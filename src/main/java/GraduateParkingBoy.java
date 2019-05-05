import exception.EmptyCarNumberException;
import exception.ParkingLotsFullException;
import exception.TicketInvalidException;
import exception.TicketNullException;

import java.util.List;


public class GraduateParkingBoy {

    public void park(Car car, List<ParkingLot> parkingLots) {
        if (car.getNumber().equals("")){ throw new EmptyCarNumberException(); }
    }
}