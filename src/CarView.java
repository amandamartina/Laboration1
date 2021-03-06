import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * This class represents graphics only.
 */
public class CarView extends JPanel implements Observer {
    /**
     * A carmodel of type ListAccessor, is gives access the list of cars.
     */
    private ListAccessor carModel;
    /**
     * A map containing a MotorVehicle as key and an image as value.
     */
    private Map<MotorVehicle, CarImages> imageMap = new HashMap<>();

    /**
     * This constructor creates CarView objects.
     *
     * @param carModel a CarModel, representing our model.
     * @param x        sets the width of the frame
     * @param y        sets the height of the frame
     */
    public CarView(ListAccessor carModel, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carModel = carModel;
    }

    /**
     * This method is updating the images of the cars.
     */
    public void updateImages() {
        Map<MotorVehicle, CarImages> tempMap = new HashMap<>();
        for (MotorVehicle car : carModel.getCars()) {
            tempMap.put(car, new CarImages(car));
        }
        imageMap = tempMap;
    }

    /**
     * Method that paints the pictures.
     *
     * @param g The graphics object used.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MotorVehicle car : imageMap.keySet()) {
            imageMap.get(car).drawCar(car, g);
        }
    }

    /**
     * This method listens to the model when it has been observed that
     * changes related to the images has been made.
     * This method is a part of the observer pattern that has been applied.
     */
    @Override
    public void actOnUpdate() {
        updateImages();
        repaint();
    }
}