import org.junit.Assert;
import org.junit.Test;

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
}
