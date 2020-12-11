import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    CarModel carModel;

    public CarController(CarModel model) {
        this.carModel = model;
    }
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 20;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    protected Timer timer = new Timer(delay, new CarController.TimerListener());


    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //ArrayList<Acar> cars = new ArrayList<>();
    ArrayList<MotorVehicle> cars = new ArrayList<>();


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorVehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getxCord());
                int y = (int) Math.round(car.getyCord());
                frame.drawPanel.repaint();

                if (x > 700) {
                    car.turnLeft();
                    car.turnLeft();
                }
                if (x < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                frame.drawPanel.moveit(cars); //borde ta bort
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        //for (ACar car : cars
        for (MotorVehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (MotorVehicle car : cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (MotorVehicle car : cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOff();
            }
        }
    }

    void scaniaLiftBed() {
        for (MotorVehicle car : cars) {
            if (car instanceof Tilt) {
                ((Tilt) car).incrementTilt();
            }
        }
    }

    void lowerLiftBed() {
        for (MotorVehicle car : cars) {
            if (car instanceof Tilt) {
                ((Tilt) car).decrementTilt();
            }
        }
    }

    void startAllCars() {
        for (MotorVehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (MotorVehicle car : cars) {
            car.stopEngine();
        }
    }
}
