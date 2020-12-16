import javax.swing.*;

public class SpeedView extends JPanel implements Observer { //en panel som innehåller en eller flera labels
    private ListAccessor carModel;
    JLabel jlabel = new JLabel();

    public SpeedView(ListAccessor carModel) {
        this.carModel = carModel;
        this.add(jlabel);
        updateSpeed();
    }

    public void updateSpeed() {
        String carLabel = " ";
        for (MotorVehicle car : carModel.getCars()) {
            carLabel = carLabel + " " + car.getModelName() + " " + car.getCurrentSpeed();
        }
        jlabel.setText(carLabel);
        revalidate();
    }

    @Override
    public void actOnUpdate() {
        updateSpeed();
    }
}