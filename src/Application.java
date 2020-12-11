import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        String framename = "CarSim 1.0";
        CarModel cm = new CarModel(initCars());
        CarView cv = new CarView(framename);
        CarController cc = new CarController(cm, cv);
        ;
        //cm.cars.add(new Volvo240());
        //cm.cars.add(new Saab95());
        //cm.cars.add(new Scania());


        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
