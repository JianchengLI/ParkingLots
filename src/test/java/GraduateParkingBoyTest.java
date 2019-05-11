import exception.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraduateParkingBoyTest {

    @Test
    public void should_throw_empty_car_number_exception_when_park_given_a_car_without_number(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows( EmptyCarNumberException.class, ()-> {
            graduateParkingBoy.park(new Car(""), parkingLots);
        });
    }

    @Test
    public void should_throw_park_lots_full_exception_when_park_given_some_parkinglots_all_full(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(0);
        ParkingLot parkingLotB = new ParkingLot(0);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows(ParkingLotsFullException.class, () -> {
            graduateParkingBoy.park(new Car("CN123456"), parkingLots);
        });
    }

    @Test
    public void should_return_ticket_and_park_in_the_first_available_parkingLot_when_park_given_some_parkinglots_within_more_than_one_available_and_a_car_with_number(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        final String carNumber = "CN123456";
        Ticket ticket = graduateParkingBoy.park(new Car(carNumber), parkingLots);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(carNumber, ticket.getNumber());

        Assert.assertTrue(parkingLotA.hasCarNumber(carNumber));
        Assert.assertFalse(parkingLotB.hasCarNumber(carNumber));
    }

    @Test
    public void should_throws_duplicate_car_number_exception_when_park_given_two_car_with_same_number(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        final String number = "CN123456";
        Car car = new Car(number);
        graduateParkingBoy.park(car, parkingLots);

        Car duplicateNumberCar = new Car(number);
        assertThrows(DuplicateCarNumberException.class, ()->{
            graduateParkingBoy.park(duplicateNumberCar, parkingLots);
        });
    }

    @Test
    public void should_throw_ticket_null_exception_when_pick_given_nothing(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows(TicketNullException.class, ()->{
            graduateParkingBoy.pick(null, parkingLots);
        });
    }

    @Test
    public void should_throw_ticket_invalid_exception_when_pick_given_invalid_ticket_and_parking_lots(){
        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        assertThrows(TicketInvalidException.class, ()->{
            graduateParkingBoy.pick(new Ticket("Invalid"), parkingLots);
        });
    }

    @Test
    public void should_return_car_when_pick_given_valid_ticket_and_parkinglots(){
        Car entryCar = new Car("CN123456");

        ParkingBoy graduateParkingBoy = new ParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        Ticket ticket = graduateParkingBoy.park(entryCar, parkingLots);
        Car pickedCar = graduateParkingBoy.pick(ticket, parkingLots);
        Assert.assertEquals(entryCar, pickedCar);
    }
}