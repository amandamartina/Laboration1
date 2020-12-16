import javax.swing.*;

public class SpeedView extends JPanel implements Observer { //en panel som innehåller en eller flera labels
    private ListAccessor carModel;
    JLabel jlabel = new JLabel();

    public SpeedView(ListAccessor carModel, int x, int y) {
        this.carModel = carModel;
        this.add(jlabel);
        addSpeedLabel();
    }

    public void addSpeedLabel() {
        for (MotorVehicle car : carModel.getCars()) {
            String as = jlabel.getText();
            jlabel.setText(as + " " + car.getModelName() + " " + car.getCurrentSpeed());
        }
        revalidate();
    }

    public void updateSpeed() { //ska ändras
        for (MotorVehicle car : carModel.getCars()) {
            String as = jlabel.getText();
            jlabel.setText(car.getModelName() + " " + car.getCurrentSpeed());
        }
    }

    @Override
    public void actOnUpdate() {
        addSpeedLabel();
        updateSpeed();
    }
}