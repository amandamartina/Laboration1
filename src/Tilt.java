/**
 * Interface which contains tilt functions for motor vehicle with cargo.
 */

public interface Tilt {
    /**
     * Method to make the cargo tilt up
     */
    void tiltUp(double x);

    /**
     * Method to make the cargo tilt down
     */
    void tiltDown(double y);
}
