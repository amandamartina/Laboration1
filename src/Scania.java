import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends MotorVehicle implements Tilt, CarImages {
    private double currentTilt; //The tilt of the cars cargo
    private static final double INITIAL = 0; //The minimum tilt of the cargo is equal to zero degrees. This is the initial tilt of the cargo.
    private static final double MAX = 70; //The maximum tilt of the cargo is equal to 70 degrees
    private static final int INCREMENT = 5;
    private BufferedImage scaniaImage;

    /**
     * Constructor for Scania objects
     */
    public Scania() {
        super(2, Color.blue, 150, "Scania", 10000, 0, 200);
        this.currentTilt = INITIAL;
        stopEngine();
        try {
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method to change the tilt of the cargo that is higher than the original tilt.
     *
     *
     */
    @Override
    public void incrementTilt() {
        if (getCurrentSpeed() == 0) {
            if (currentTilt < MAX) {
                currentTilt += INCREMENT;
            }
        }
    }


    /**
     * Same as tiltUp but to a tilt that is lower than the original tilt.
     *
     *
     */
    @Override
    public void decrementTilt() {
        if (getCurrentSpeed() == 0) {
            if (currentTilt > INITIAL)
                currentTilt -= INCREMENT;
        }
    }

    /**
     * Method to increase the speed of the vehicle and can be used if the current tilt is zero.
     *
     * @param amount amount is a factor in incrementSpeed.
     */
    @Override
    public void gas(double amount) {
        if (currentTilt == 0) {
            super.gas(amount);
        }
    }

    /**
     * Uses a constant number to increase the speed factor
     *
     * @return enginePower times 0.01 times turbo
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Method that says that the tilt is equal to zero when the cargo is down
     */
    public boolean tiltDown() {
        return (currentTilt == 0);
    }

    /**
     * Getter for the current tilt
     *
     * @return the tilt that the cargo has
     */
    public double getCurrentTilt() {
        return currentTilt;
    }

    @Override
    public BufferedImage getCarImage() {
        return scaniaImage;
    }
}