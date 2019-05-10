import exception.*;

import java.util.List;
import java.util.Optional;


public class GraduateParkingBoy {

    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        if(car.getNumber().equals("")){ throw new EmptyCarNumberException(); }
        if(hasCarNumber(car, parkingLots)){ throw new DuplicateCarNumberException(); }

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
        //Note: This will not iterate the whole collection, because streams are lazily evaluated
        //      - it will stop at the first object that matches the condition)
        Optional<ParkingLot> parkingLotFound = parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.hasTicket(ticket))
                .findFirst();
        return parkingLotFound.isEmpty() ? null : parkingLotFound.get();
    }

    private ParkingLot findFirstAvailableParkingLot(List<ParkingLot> parkingLots) {
        Optional<ParkingLot> parkingLotFound = parkingLots
                .stream()
                .filter(ParkingLot::isAvailable)
                .findFirst();

        return parkingLotFound.isEmpty() ? null : parkingLotFound.get();
    }

    private boolean hasCarNumber(Car car, List<ParkingLot> parkingLots){
        return parkingLots
                .stream()
                .anyMatch(parkingLot -> parkingLot.hasCarNumber(car.getNumber()));


    }
}

