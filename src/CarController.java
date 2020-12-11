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
    final CarModel carModel;
    final CarView carView;

    public CarController(CarModel model, CarView view) {
        this.carModel = model;
        this.carView = view;

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        carView.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.gas();
            }

        });
        carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.brake();
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.startAllCars();
            }
        });
        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.stopAllCars();
            }
        });
        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOn();
            }
        });
        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOff();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.scaniaLiftBed();
            }

        });
        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.lowerLiftBed();
            }
        });
    }
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 20;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    protected Timer timer = new Timer(delay, new CarController.TimerListener());

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
                carView.drawPanel.repaint();

                if (x > 700) {
                    car.turnLeft();
                    car.turnLeft();
                }
                if (x < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                carView.drawPanel.moveit(cars); //borde ta bort
            }
        }
    }
}
