import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {

    @Test
    public void should_return_a_ticket_and_parking_the_car_in_the_most_parkingLot_which_have_most_space_when_parking_given_a_car_with_a_number_and_some_parkingLots(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotMostCapacity = new ParkingLot(100);
        ParkingLot parkingLotLessCapacity = new ParkingLot(50);
        parkingLots.add(parkingLotMostCapacity);
        parkingLots.add(parkingLotLessCapacity);

        ParkingBoy smartParkingBoy = new ParkingBoy(new SmartParkingSkill());
        final String carNumber = "CN123456";
        Car entryCar = new Car(carNumber);
        Ticket ticket = smartParkingBoy.park(entryCar, parkingLots);

        Assert.assertNotNull(ticket);
        Assert.assertTrue(parkingLotMostCapacity.hasCarNumber(carNumber));
        Assert.assertFalse(parkingLotLessCapacity.hasCarNumber(carNumber));
    }
}
