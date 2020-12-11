public class CarFactory {

    public static MotorVehicle createVolvo() {
        return new Volvo240();
    }

    public static MotorVehicle createSaab() {
        return new Saab95();
    }

    public static MotorVehicle createScania() {
        return new Scania();
    }
}
