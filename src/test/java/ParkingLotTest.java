import exception.EmptyCarNumberException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_parking_given_an_available_parking_lot_and_car_with_number(){
        final String carNumber = "CN123456";
        Car car = new Car(carNumber);
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getNumber());
    }

    @Test
    public void should_return_car_number_exception_when_parking_given_an_available_parking_lot_and_car_without_number(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("");

        assertThrows(EmptyCarNumberException.class, ()->{
            parkingLot.park(car);
        });
    }
}
