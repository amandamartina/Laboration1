import java.util.ArrayList;
import java.util.List;

public class CarModel { //x och y-koordinaterna ska uppdateras i modellen, viewen ska vara dum
    //observern: du ändrar något i modellen sen ska du skicka det till alla som lyssnar (ska skicka bilen för att få x- och y-koordinaten)
    ArrayList<MotorVehicle> cars = new ArrayList<>();
    ArrayList<Observer> listeners = new ArrayList<>();
    int gasAmount = 50;
    int breakAmount = 50;

    public CarModel (List<MotorVehicle> cars) {
        this.cars.addAll(cars);
    }

    public void addListener(Observer l) {
        listeners.add(l);
    }

    public void notifyListeners() {
        //kolla sliden
    }

    public void addCar(MotorVehicle car) {
        cars.add(car);
    }

    // Calls the gas method for each car once
    void gas() {
        double gas = ((double) gasAmount) / 100;
        //for (ACar car : cars
        for (MotorVehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake() {
        double brake = (( double)breakAmount) / 100;
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
