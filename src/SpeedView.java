import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class SpeedView extends JLabel implements Observer {
    private ListAccessor carModel;
    JLabel jlabel = new JLabel();
    Map<MotorVehicle, Double> speedMap = new HashMap<>();

    public SpeedView(ListAccessor carModel, int x, int y) {
        this.carModel = carModel;
        addSpeedView();
    }


    public void addSpeedView() {
        Map<MotorVehicle, Double> tempMap = new HashMap<>();
        for (MotorVehicle car : carModel.getCars()) {
            tempMap.put(car, car.getCurrentSpeed());
            jlabel.setText(printOutSpeed(car));
        }
    }

    private String printOutSpeed(MotorVehicle car) {
        return (car.getModelName() + car.getCurrentSpeed());
    }


    @Override
    public void actOnUpdate() {
        addSpeedView();
    }

}

