import exception.EmptyCarNumberException;
import exception.ParkingLotsFullException;
import exception.TicketNullException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraduateParkingBoyTest {

    @Test
    public void should_throw_empty_car_number_exception_when_park_given_a_car_without_number(){
        GraduateParkingBoy boy = new GraduateParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows( EmptyCarNumberException.class, ()-> {
            boy.park(new Car(""), parkingLots);
        });
    }

    @Test
    public void should_throw_park_lots_full_exception_when_park_given_some_parkinglots_all_full(){
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(0);
        ParkingLot parkingLotB = new ParkingLot(0);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows(ParkingLotsFullException.class, () -> {
            parkingBoy.park(new Car("CN123456"), parkingLots);
        });
    }

    @Test
    public void should_return_ticket_when_park_given_some_parkinglots_within_more_than_one_available_and_a_car_with_number(){
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        final String carNumber = "CN123456";
        Ticket ticket = parkingBoy.park(new Car(carNumber), parkingLots);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(carNumber, ticket.getNumber());
    }

    @Test
    public void should_throw_ticket_null_exception_when_pick_given_nothing(){
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows(TicketNullException.class, ()->{
            parkingBoy.pick(null, parkingLots);
        });
    }

}