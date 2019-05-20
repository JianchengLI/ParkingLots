import java.util.List;
import java.util.Optional;

public class GraduateParkingSkill implements IParkingSkill {

    @Override
    public ParkingLot findAvailableParkingLot(List<ParkingLot> parkingLots) {
        return findFirstAvailableParkingLot(parkingLots);
    }

    private ParkingLot findFirstAvailableParkingLot(List<ParkingLot> parkingLots) {
        Optional<ParkingLot> parkingLotFound = parkingLots
                .stream()
                .filter(ParkingLot::isAvailable)
                .findFirst();

        return parkingLotFound.orElse(null);
    }
}
