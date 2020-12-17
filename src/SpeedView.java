import javax.swing.*;

/**
 * This class is a part of the MVC-pattern that has been applied.
 * It is a View that shows the speed of each car that is a part of the list of cars in the model.
 */
public class SpeedView extends JPanel implements Observer { //en panel som innehåller en eller flera labels
    /**
     * An object of type ListAccessor.
     */
    private final ListAccessor carModel;
    /**
     * An object of type JLabel.
     */
    JLabel jlabel = new JLabel();

    /**
     * The speedView constructor that creates speedView objects.
     *
     * @param carModel A parameter of type ListAccessor that gives access to the list of cars in the model.
     */
    public SpeedView(ListAccessor carModel) {
        this.carModel = carModel;
        this.add(jlabel);
        updateSpeed();
    }

    /**
     * This method is updating the labels that includes the cars names and speeds with the accurate speed.
     */
    public void updateSpeed() {
        String carLabel = " ";
        for (MotorVehicle car : carModel.getCars()) {
            carLabel = carLabel + " " + car.getModelName() + " " + car.getCurrentSpeed();
        }
        jlabel.setText(carLabel);
        revalidate();
    }

    /**
     * This method listens to the model when it has been observed that
     * changes related the speed of the cars has been made.
     * This method is a part of the observer pattern that has been applied.
     */
    @Override
    public void actOnUpdate() {
        updateSpeed();
    }
}