import java.util.ArrayList;
import java.util.List;

public class CarModel implements ButtonsAccessor, ListAccessor{
    List<MotorVehicle> cars = new ArrayList<>();
    List<Observer> listeners = new ArrayList<>();

    public CarModel() {
    }

    public void addListener(Observer l) {
        listeners.add(l);
    }

    public void notifyListeners() {
        //kolla sliden
    }

    public void addCar(MotorVehicle car) {
        cars.add(car);
        notifyListeners();
    }

    // Calls the gas method for each car once
    public void gas(int gasAmount) {
        double gas = ((double) gasAmount) / 100;
        //for (ACar car : cars
        for (MotorVehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    public void brake(int gasAmount) {
        double brake = ((double) gasAmount) / 100;
        for (MotorVehicle car : cars) {
            car.brake(brake);
        }
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
