import com.codurance.lsp.ElectricCar;
import com.codurance.lsp.FillingStation;
import com.codurance.lsp.PetrolCar;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FillingStationShould {

    private static final int FULL = 100;
    private static final int EMPTY = 0;
    private final FillingStation fillingStation = new FillingStation();

    @Test
    public void refuel_a_petrol_car(){
        PetrolCar car = new PetrolCar();
        fillingStation.refuel(car);
        assertThat(car.fuelTankLevel())
                .isEqualTo(FULL);
    }


    @Test
    public void not_refuel_a_electric_car(){
        ElectricCar car = new ElectricCar();
        fillingStation.refuel(car);
        assertThat(car.fuelTankLevel())
                .isEqualTo(EMPTY);
    }
}
