import java.util.ArrayList;

public class CarModel {
    ArrayList<MotorVehicle> cars = new ArrayList<>();
    ArrayList<Observer> listeners = new ArrayList<>();
    int gasAmount = 0;

    public void addListener(Observer l) {
        listeners.add(l);
    }

    public void notifyListeners() {

    }

    public void addCars(MotorVehicle car) {
        cars.add(car);
    }
}
