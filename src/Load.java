/**
 * Interface that contains functions for a loading-vehicle.
 */
public interface Load {
    /**
     * Method to load a car on the car-transport.
     *
     * @param car the MotorVehicle-object you want to load on the transport.
     */
    void loadCar(MotorVehicle car);

    /**
     * Method to unload a car from the car-transport.
     */
    void unloadCar();

    /**
     * Method that measures the distance between the car-transport and the car you want to load.
     *
     * @param car the MotorVehicle-object you want to load to the car-transport.
     * @return Returns true if the car is close enough to the car-transport, fa
     */
    boolean loadingDistance(MotorVehicle car);
}
