import java.util.Comparator;
import java.util.List;

public class SmartParkingSkill implements IParkingSkill {

    @Override
    public ParkingLot findAvailableParkingLot(List<ParkingLot> parkingLots) {
        return findMostCapacityLeftParkingLot(parkingLots);
    }

    private ParkingLot findMostCapacityLeftParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getCapacityLeft))
                .orElse(parkingLots.get(0));
    }
}
