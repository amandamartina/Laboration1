import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

/**
 * This class is used to set the pictures that are found in the directory "pics" that belongs to each car.
 */
public class CarImages {
    /**
     * A BufferedImage object called image.
     */
    BufferedImage image;

    /**
     * This method is using a try-catch statement to set one image to one MotorVheicle object.
     *
     * @param car The MotorVehicle object to which an image is set.
     */
    public CarImages(MotorVehicle car) {
        {
            try {
                image = read(CarView.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to draw the cars, that's represented with the picture that is set in the constructor.
     *
     * @param car The car you want to draw.
     * @param g   The graphics object used in the method.
     */
    public void drawCar(MotorVehicle car, Graphics g) {
        g.drawImage(image, (int) car.getxCord(), (int) car.getyCord(), null);
    }
}

