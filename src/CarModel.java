import java.util.ArrayList;
import java.util.List;

/**
 * This class is containing the model, of which the rest on the MVC-pattern depends to do calculations.
 */
public class CarModel implements ButtonsAccessor, ListAccessor {
    /**
     * The list that we put the cars in.
     */
    List<MotorVehicle> cars = new ArrayList<>();
    List<Observer> listeners = new ArrayList<>();

    /**
     * The CarModel constructor.
     * This constructor creates CarModel object.
     */
    public CarModel() {
    }

    /**
     * Method to move the cars in the list, update their x- and y-coordinates and make sure the car
     * stays within the frame. It also notifies the listeners in the list of listeners.
     */
    public void update() {
        for (MotorVehicle car : cars) {
            car.move();
            int x = (int) Math.round(car.getxCord());
            int y = (int) Math.round(car.getyCord());

            if (x < 0 || x > 700) {
                car.turnLeft();
                car.turnLeft();
            }
        }
        notifyListeners();
    }

    public void addListener(Observer l) {
        listeners.add(l);
    }

    public void notifyListeners() {
        for (Observer observer : listeners) {
            observer.actOnUpdate();
        }
    }

    /**
     * This method adds MotorVehicle objects to the list "cars".
     * @param car The car you want to add.
     */
    public void addCar(MotorVehicle car) {
        if (cars.size() < 10) {
            car.setyCord(cars.size() * 100);
            cars.add(car);
            notifyListeners();
        }
    }

    /**
     * Method that removes the car in the end of the list of MotorVehicle-objects.
     */
    public void removeCar() {
        if (cars.size() > 0) {
            cars.remove(cars.size()-1);
        }
    }

    // Calls the gas method for each car once
    public void gas(int gasAmount) {
        double gas = ((double) gasAmount) / 100;
        for (MotorVehicle car : cars
        ) {
            car.gas(gas);
        }
        notifyListeners();
    }

    /**
     * This method is used to decrease the speed of the cars.
     * @param gasAmount The amount you want to slow the speed down with.
     */
    public void brake(int gasAmount) {
        double brake = ((double) gasAmount) / 100;
        for (MotorVehicle car : cars) {
            car.brake(brake);
        }
        notifyListeners();
    }

    public void turboOn() {
        for (MotorVehicle car : cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (MotorVehicle car : cars) {
            if (car instanceof Turbo) {
                ((Turbo) car).setTurboOff();
            }
        }
    }

    public void scaniaLiftBed() {
        for (MotorVehicle car : cars) {
            if (car instanceof Tilt) {
                ((Tilt) car).incrementTilt();
            }
        }
    }

    /**
     * This method is used to lower the cargo of a truck that has been lifted.
     */
    public void lowerLiftBed() {
        for (MotorVehicle car : cars) {
            if (car instanceof Tilt) {
                ((Tilt) car).decrementTilt();
            }
        }
    }

    /**
     * This method is used to start all cars with a specific amount of gas.
     */
    public void startAllCars() {
        for (MotorVehicle car : cars) {
            car.startEngine();
        }
        notifyListeners();
    }

    /**
     * This method is used to stop all cars.
     * In other words, this method is putting the speed of all cars to zero.
     */
    public void stopAllCars() {
        for (MotorVehicle car : cars) {
            car.stopEngine();
        }
        notifyListeners();
    }

    public List<MotorVehicle> getCars() {
        return cars;
    }
}
