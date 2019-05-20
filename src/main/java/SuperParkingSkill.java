import java.util.Comparator;
import java.util.List;

public class SuperParkingSkill implements IParkingSkill {
    @Override
    public ParkingLot findAvailableParkingLot(List<ParkingLot> parkingLots) {
        return findMostVacancyRateParkingLot(parkingLots);
    }

    private ParkingLot findMostVacancyRateParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getVacancyRate))
                .orElse(parkingLots.get(0));
    }
}
