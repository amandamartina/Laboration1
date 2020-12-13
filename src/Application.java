import javax.swing.*;
import java.awt.*;

public class Application {

    public static void initCars(CarModel cm) {
        cm.addCar(CarFactory.createVolvo());
        cm.addCar(CarFactory.createSaab());
        cm.addCar(CarFactory.createScania());
    }

    public static void main(String[] args) {
        // Instance of this class
        JFrame jFrame = new JFrame("CarSim 1.0");

        jFrame.setPreferredSize(new Dimension(800, 800));
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //String framename = "CarSim 1.0";
        CarModel cm = new CarModel();
        initCars(cm);
        CarView cv = new CarView(cm, 800, 560);
        CarController cc = new CarController(cm, 800);

        cm.addListener(cv);

        jFrame.add(cv);
        jFrame.add(cc);

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
        cc.timer.start();
    }
}
