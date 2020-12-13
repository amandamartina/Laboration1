import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class CarImages {
    BufferedImage image;

    public CarImages(MotorVehicle car) {
        {
            try {
                image = read(DrawPanel.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawCar(MotorVehicle car, Graphics g) {
        g.drawImage(image, (int) car.getxCord(), (int) car.getyCord(), null);
    }
}

