import java.util.ArrayList;
import java.util.List;

public class CarModel implements ButtonsAccessor, ListAccessor{
    List<MotorVehicle> cars = new ArrayList<>();
    List<Observer> listeners = new ArrayList<>();

    public CarModel() {
    }
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
        notifyListeners();
    }

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

    public void lowerLiftBed() {
        for (MotorVehicle car : cars) {
            if (car instanceof Tilt) {
                ((Tilt) car).decrementTilt();
            }
        }
    }

    public void startAllCars() {
        for (MotorVehicle car : cars) {
            car.startEngine();
        }
        notifyListeners();
    }

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
