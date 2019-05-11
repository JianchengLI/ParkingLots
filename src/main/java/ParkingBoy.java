import exception.*;
import java.util.List;

public class ParkingBoy {
    private IParkingSkill parkingSkill;

    public ParkingBoy(){
        this.parkingSkill = new GraduateParkingSkill();
    }

    public ParkingBoy(IParkingSkill parkingSkill) {
        this.parkingSkill = parkingSkill;
    }

    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        if(car.getNumber().equals("")){ throw new EmptyCarNumberException(); }
        if(parkingSkill.isCarNumberDuplicate(car, parkingLots)){ throw new DuplicateCarNumberException(); }

        ParkingLot parkingLot = parkingSkill.findAvailableParkingLot(parkingLots);
        if(parkingLot == null){ throw new ParkingLotsFullException(); }
        return parkingLot.park(car);
    }

    public Car pick(Ticket ticket, List<ParkingLot> parkingLots) {
        if(ticket == null){ throw new TicketNullException(); }
        ParkingLot parkingLot = parkingSkill.findParkingLotByTicket(ticket, parkingLots);
        if(parkingLot == null){ throw new TicketInvalidException(); }
        return parkingLot.pick(ticket);
    }
}

