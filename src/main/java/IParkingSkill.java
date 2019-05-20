import java.util.List;
import java.util.Optional;

public interface IParkingSkill {

    ParkingLot findAvailableParkingLot(List<ParkingLot> parkingLots);

    default ParkingLot findParkingLotByTicket(Ticket ticket, List<ParkingLot> parkingLots){
        Optional<ParkingLot> parkingLotFound = parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.hasTicket(ticket))
                .findFirst();
        return parkingLotFound.orElse(null);
    }

    default boolean isCarNumberDuplicate(Car car, List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .anyMatch(parkingLot -> parkingLot.hasCarNumber(car.getNumber()));
    }
}
