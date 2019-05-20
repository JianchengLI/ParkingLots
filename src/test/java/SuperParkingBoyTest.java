import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest {
    @Test
    public void should_return_a_ticket_and_parking_the_car_in_parkinglot_which_have_the_most_vacancy_rate_when_parking_given_a_car_with_a_number_and_some_parkingLots(){
        final String carNumber = "CN86868866";
        Car entryCar = new Car(carNumber);
        ParkingLot mostVacancyRateParkinglot = new ParkingLot(1);
        ParkingLot lessVacancyRateParkinglot = new ParkingLot(50);

        Car parkedCar = new Car("Whatever");
        lessVacancyRateParkinglot.park(parkedCar);

        ParkingBoy parkingBoy = new ParkingBoy(new SuperParkingSkill());

        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(mostVacancyRateParkinglot); // Vacancy Rate: 1/1
        parkingLotList.add(lessVacancyRateParkinglot); // Vacancy Rate: 49/50

        parkingBoy.park(entryCar, parkingLotList);

        Assert.assertTrue(mostVacancyRateParkinglot.hasCarNumber(carNumber));
        Assert.assertFalse(lessVacancyRateParkinglot.hasCarNumber(carNumber));
    }
}
