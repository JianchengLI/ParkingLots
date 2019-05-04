import exception.EmptyCarNumberException;
import exception.ParkingLotsFullException;
import exception.TicketInvalidException;
import exception.TicketNullException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_parking_given_an_available_parking_lot_and_car_with_number(){
        final String carNumber = "CN123456";
        Car car = new Car(carNumber);
        ParkingLot parkingLot = new ParkingLot(100);
        Ticket ticket = parkingLot.park(car);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getNumber());
    }

    @Test
    public void should_return_car_number_exception_when_parking_given_an_available_parking_lot_and_car_without_number(){
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car("");

        assertThrows(EmptyCarNumberException.class, ()->{
            parkingLot.park(car);
        });
    }

    @Test
    public void should_return_parkinglots_full_exception_when_parking_given_an_unavailable_parkinglots(){
        ParkingLot parkingLot = new ParkingLot(0);
        Car car1 = new Car("CN123456");

        assertThrows(ParkingLotsFullException.class, ()->{
            parkingLot.park(car1);
        });

        Car car2 = new Car("");
        assertThrows(ParkingLotsFullException.class, ()->{
            parkingLot.park(car2);
        });
    }

    @Test
    public void should_return_ticket_null_exception_when_pick_given_no_ticket(){
        ParkingLot parkingLot = new ParkingLot(100);
        assertThrows(TicketNullException.class,()->{
            parkingLot.pick(null);
        });
    }

    @Test
    public void should_return_ticket_invalid_when_pick_given_invalid_ticket(){
        ParkingLot parkingLot = new ParkingLot(100);
        Ticket ticketInvalid = new Ticket("INVALID_CAR_NUMBER");
        assertThrows(TicketInvalidException.class, ()->{
            parkingLot.pick(ticketInvalid);
        });
    }

    @Test
    public void should_get_car_when_pick_given_valid_ticket(){
        ParkingLot parkingLot = new ParkingLot(100);
        Car entryCar = new Car("CN123456");
        Ticket validTicket = parkingLot.park(entryCar);
        Car leaveCar = parkingLot.pick(validTicket);

        Assert.assertSame(entryCar, leaveCar);
    }
}
