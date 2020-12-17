import javax.swing.*;
import java.awt.*;

/**
 * This class represents the Application part in the MVC pattern.
 * It is responsible to connect the other MVC components to make the program run.
 */
public class Application {

    /**
     * Method that make it possible to add cars in a list.
     * The class CarFactory is used to create the car-objects.
     *
     * @param carModel a CarModel, representing our model.
     */
    public static void initCars(CarModel carModel) {
        carModel.addCar(CarFactory.createVolvo());
        carModel.addCar(CarFactory.createSaab());
        carModel.addCar(CarFactory.createScania());
    }

    /**
     * The main method where the the program runs.
     * Here CarModel, CarController, CarView and SpeedView are put.
     * In this method cars are added to the list that is created in CarModel. The frame conditions is also set here.
     *
     * @param args standard parameter
     */
    public static void main(String[] args) {
        // Instance of this class
        JFrame jFrame = new JFrame("CarSim 1.0");

        jFrame.setPreferredSize(new Dimension(800, 825));
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        CarModel carModel = new CarModel();
        initCars(carModel);
        CarView carView = new CarView(carModel, 800, 560);
        CarController carController = new CarController(carModel, 800);
        SpeedView speedView = new SpeedView(carModel);

        carModel.addListener(carView);
        carModel.addListener(speedView);

        jFrame.add(carView);
        jFrame.add(carController);
        jFrame.add(speedView);

        // Make the frame pack all it's components by respecting the sizes if possible.
        jFrame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2, dim.height / 2 - jFrame.getSize().height / 2);
        // Make the frame visible
        jFrame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start the timer
        carController.timer.start();
    }
}
