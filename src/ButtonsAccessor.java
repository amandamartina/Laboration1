/**
 * Interface that contains methods connected to the buttons.
 */
public interface ButtonsAccessor {
    /**
     * Method to increase the speed of a vehicle.
     * @param gasAmount The amount you want to increase the speed with.
     */
    void gas(int gasAmount);

    /**
     * Method to slow the speed down.
     * @param gasAmount The amount you want to slow the speed down with.
     */
    void brake(int gasAmount);

    /**
     * Method to set turbo on.
     */
    void turboOn();

    /**
     * Method to set turbo off.
     */
    void turboOff();

    /**
     * Method to increase tilt.
     */
    void scaniaLiftBed();

    /**
     * Method to decrease tilt.
     */
    void lowerLiftBed();

    /**
     * Method to start cars so they slowly start rolling.
     */
    void startAllCars();

    /**
     * Method to stop all cars.
     */
    void stopAllCars();

    /**
     * Method to update the cars position, also notify if it gets out of the frame. Notifies forward to
     * observers so they can act on the cange in position.
     */
    void update();

    /**
     * Method to add car to a list.
     * @param car The car you want to add.
     */
    void addCar(MotorVehicle car);

    /**
     * Method to remove car from list.
     */
    void removeCar();
}
