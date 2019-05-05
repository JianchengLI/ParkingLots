import exception.EmptyCarNumberException;
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
}