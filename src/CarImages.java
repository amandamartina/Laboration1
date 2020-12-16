import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static javax.imageio.ImageIO.*;

public class CarImages {
    BufferedImage image;

    public CarImages(MotorVehicle car) {
        {
            try {
                image = read(CarView.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawCar(MotorVehicle car, Graphics g) {
        g.drawImage(image, (int) car.getxCord(), (int) car.getyCord(), null);
    }
}

