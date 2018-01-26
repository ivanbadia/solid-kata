import com.codurance.lsp.FillingStation;
import com.codurance.lsp.PetrolCar;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FillingStationShould {

    private static final int FULL = 100;
    private final FillingStation fillingStation = new FillingStation();

    @Test
    public void refuel_a_petrol_car(){
        PetrolCar car = new PetrolCar();
        fillingStation.refuel(car);
        assertThat(car.fuelTankLevel())
                .isEqualTo(FULL);
    }
}
