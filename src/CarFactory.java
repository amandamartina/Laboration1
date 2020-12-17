public class CarFactory {

    /**
     * This method creates a Volvo240.
     * @return Volvo240
     */
    public static MotorVehicle createVolvo() {
        return new Volvo240();
    }

    /**
     * This method creates a Saab95.
     * @return Saab95
     */
    public static MotorVehicle createSaab() {
        return new Saab95();
    }

    /**
     * This method creates a Scania.
     * @return Scania
     */
    public static MotorVehicle createScania() {
        return new Scania();
    }
}
