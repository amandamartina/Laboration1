import javax.swing.*;
import java.util.ArrayList;

public class Application {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 20;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new CarController.TimerListener());


    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Acar> cars = new ArrayList<>();


    //methods:


    public static void main(String[] args) {
        // Instance of this class
        String framename = "Hello";
        CarModel cm = new CarModel();
        CarController cc = new CarController(cm);
        CarView view = new CarView(framename, cc);
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
